package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ModelImpl;
import model.PuzzleImpl;
import view.PuzzleView;

public class ControllerImpl {

  private ModelImpl m;
  public ControllerImpl() {

  }

  public void setModel(ModelImpl model) {
    m = model;
  }
  public ModelImpl getModel() {
   return m;
  }
  public void clickNextPuzzle() {
    if (m.getActivePuzzleIndex() < m.getPuzzleLibrarySize() - 1) {
      m.setActivePuzzleIndex(m.getActivePuzzleIndex() + 1);
    }
  }
  public void clickPrevPuzzle() {
    if (m.getActivePuzzleIndex() > 0) {
      m.setActivePuzzleIndex(m.getActivePuzzleIndex() - 1);
    }
  }
  public void clickRandPuzzle() {
    int min = 0;
    int max = m.getPuzzleLibrarySize() - 1;
    int b = (int) (Math.random() * (max - min + 1) + min);
    while (b == m.getActivePuzzleIndex()) {b = (int) (Math.random() * (max - min + 1) + min);}
    m.setActivePuzzleIndex(b);
  }
  public void clickResetPuzzle() {
    m.resetPuzzle();
  }
  public void clickCell(int r, int c) {
    if (!isLamp(r, c)) {
      m.addLamp(r, c);
    } else {
      m.removeLamp(r, c);
    }
  }
  public boolean isLit(int r, int c) {
    return m.isLit(r, c);
  }
  public boolean isLamp(int r, int c) {
    return m.isLamp(r, c);
  }
  public boolean isClueSatisfied(int r, int c) {
    return m.isClueSatisfied(r, c);
  }
  public boolean isSolved() {
    return m.isSolved();
  }
  public PuzzleImpl getActivePuzzle() {
    return m.getActivePuzzle();
  }
  public boolean isLampIllegal(int r, int c) {
    return m.isLampIllegal(r, c);
  }
  public void addLamp(int r, int c) {
    m.addLamp(r, c);
  }
  public void removeLamp(int r, int c) {
    m.removeLamp(r, c);
  }
  public boolean isClueOver(int r, int c) {
    return m.isClueOver(r, c);
  }
  public int currentPuzzleNum() {
    return m.getActivePuzzleIndex();
  }
  public int getLibrarySize() {
    return m.getPuzzleLibrarySize();
  }
}

