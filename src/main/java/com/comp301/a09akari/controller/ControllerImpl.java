package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

public class ControllerImpl implements AlternateMvcController {

  private final Model m;

  public ControllerImpl(Model model) {
    m = model;
  }

  @Override
  public void clickNextPuzzle() {
    if (m.getActivePuzzleIndex() < m.getPuzzleLibrarySize() - 1) {
      m.setActivePuzzleIndex(m.getActivePuzzleIndex() + 1);
    }
  }

  @Override
  public void clickPrevPuzzle() {
    if (m.getActivePuzzleIndex() > 0) {
      m.setActivePuzzleIndex(m.getActivePuzzleIndex() - 1);
    }
  }

  @Override
  public void clickRandPuzzle() {
    int min = 0;
    int max = m.getPuzzleLibrarySize() - 1;
    int b = (int) (Math.random() * (max - min + 1) + min);
    m.setActivePuzzleIndex(b);
  }

  @Override
  public void clickResetPuzzle() {
    m.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    if (!isLamp(r, c)) {
      m.addLamp(r, c);
    } else {
      m.removeLamp(r, c);
    }
  }

  @Override
  public boolean isLit(int r, int c) {
    return m.isLit(r, c);
  }

  @Override
  public boolean isLamp(int r, int c) {
    return m.isLamp(r, c);
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    return m.isClueSatisfied(r, c);
  }

  @Override
  public boolean isSolved() {
    return m.isSolved();
  }

  @Override
  public Puzzle getActivePuzzle() {
    return m.getActivePuzzle();
  }

  @Override
  public boolean isLampIllegal(int r, int c) {
    return m.isLampIllegal(r, c);
  }

  @Override
  public void addLamp(int r, int c) {
    m.addLamp(r, c);
  }

  @Override
  public void removeLamp(int r, int c) {
    m.removeLamp(r, c);
  }

  @Override
  public boolean isClueOver(int r, int c) {
    return m.isClueOver(r, c);
  }

  @Override
  public int currentPuzzleNum() {
    return m.getActivePuzzleIndex();
  }

  @Override
  public int getLibrarySize() {
    return m.getPuzzleLibrarySize();
  }
}
