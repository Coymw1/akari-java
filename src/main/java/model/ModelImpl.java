package model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl {
  private final PuzzleLibraryImpl puzzleLib;
  //lightLib tracks lamp placement for each puzzle in puzzleLib
  private final List<int[][]> lightLib;
  private int currentPuzzleIndex;
  private final List<ModelObserver> observers;

  public ModelImpl(PuzzleLibraryImpl library) {
    puzzleLib = library;
    observers = new ArrayList<>();
    lightLib = new ArrayList<>();
    for (int i = 0; i < puzzleLib.size(); i++) {
      lightLib.add(new int[puzzleLib.getPuzzle(i).getHeight()][puzzleLib.getPuzzle(i).getWidth()]);
    }
    currentPuzzleIndex = 0;
  }


  public void addLamp(int r, int c) {
    if (r >= getActivePuzzle().getHeight() || c >= getActivePuzzle().getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (r < 0 || c < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (getActivePuzzle().getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }

    if (!isLamp(r, c)) {
      lightLib.get(currentPuzzleIndex)[r][c] = 1;
    }
    for (ModelObserver o : observers) {
      o.update(this);
    }
  }


  public void removeLamp(int r, int c) {
    if (r >= getActivePuzzle().getHeight() || c >= getActivePuzzle().getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (r < 0 || c < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (getActivePuzzle().getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }

    if (isLamp(r, c)) {
      lightLib.get(currentPuzzleIndex)[r][c] = 0;
    }

    for (ModelObserver o : observers) {
      o.update(this);
    }
  }


  public boolean isLit(int r, int c) {
    if (r >= getActivePuzzle().getHeight() || c >= getActivePuzzle().getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (r < 0 || c < 0) {
      throw new IndexOutOfBoundsException();
    }

    int i = 0;
    while (c + i < getActivePuzzle().getWidth()) {
      if (getActivePuzzle().getCellType(r, c + i) == CellType.CLUE
          || getActivePuzzle().getCellType(r, c + i) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r][c + i] == 1) {
        return true;
      }
      i++;
    }

    i = 0;
    while (c - i >= 0) {
      if (getActivePuzzle().getCellType(r, c - i) == CellType.CLUE
          || getActivePuzzle().getCellType(r, c - i) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r][c - i] == 1) {
        return true;
      }
      i++;
    }
    i = 0;
    while (r + i < getActivePuzzle().getHeight()) {
      if (getActivePuzzle().getCellType(r + i, c) == CellType.CLUE
          || getActivePuzzle().getCellType(r + i, c) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r + i][c] == 1) {
        return true;
      }
      i++;
    }
    i = 0;
    while (r - i >= 0) {
      if (getActivePuzzle().getCellType(r - i, c) == CellType.CLUE
          || getActivePuzzle().getCellType(r - i, c) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r - i][c] == 1) {
        return true;
      }
      i++;
    }

    return false;
  }


  public boolean isLamp(int r, int c) {
    if (r >= getActivePuzzle().getHeight() || c >= getActivePuzzle().getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (r < 0 || c < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (getActivePuzzle().getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }

    return (lightLib.get(currentPuzzleIndex)[r][c] == 1);
  }


  public boolean isLampIllegal(int r, int c) {
    if (r >= getActivePuzzle().getHeight() || c >= getActivePuzzle().getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (r < 0 || c < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (lightLib.get(currentPuzzleIndex)[r][c] != 1) {
      throw new IllegalArgumentException();
    }

    // to check if lamp is illegal, start from position of the lamp and check each direction
    // if another lamp is reached before wall, current lamp is illegal
    // this must apply to all 4 directions
    // same logic as isLit()
    int i = 1;
    while (c + i < getActivePuzzle().getWidth()) {
      if (getActivePuzzle().getCellType(r, c + i) == CellType.CLUE
          || getActivePuzzle().getCellType(r, c + i) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r][c + i] == 1) {
        return true;
      }
      i++;
    }

    i = 1;
    while (c - i >= 0) {
      if (getActivePuzzle().getCellType(r, c - i) == CellType.CLUE
          || getActivePuzzle().getCellType(r, c - i) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r][c - i] == 1) {
        return true;
      }
      i++;
    }

    i = 1;
    while (r + i < getActivePuzzle().getHeight()) {
      if (getActivePuzzle().getCellType(r + i, c) == CellType.CLUE
          || getActivePuzzle().getCellType(r + i, c) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r + i][c] == 1) {
        return true;
      }
      i++;
    }

    i = 1;
    while (r - i >= 0) {
      if (getActivePuzzle().getCellType(r - i, c) == CellType.CLUE
          || getActivePuzzle().getCellType(r - i, c) == CellType.WALL) {
        break;
      }
      if (lightLib.get(currentPuzzleIndex)[r - i][c] == 1) {
        return true;
      }
      i++;
    }

    return false;
  }


  public PuzzleImpl getActivePuzzle() {
    return puzzleLib.getPuzzle(getActivePuzzleIndex());
  }


  public int getActivePuzzleIndex() {
    return currentPuzzleIndex;
  }


  public void setActivePuzzleIndex(int index) {
    if (index < 0 || index >= puzzleLib.size()) {
      throw new IndexOutOfBoundsException();
    }
    currentPuzzleIndex = index;
    updateObservers();
  }


  public int getPuzzleLibrarySize() {
    return puzzleLib.size();
  }


  public void resetPuzzle() {
    lightLib.set(
        currentPuzzleIndex,
        new int[puzzleLib.getPuzzle(currentPuzzleIndex).getHeight()]
            [puzzleLib.getPuzzle(currentPuzzleIndex).getWidth()]);

    updateObservers();
  }


  public boolean isSolved() {
    for (int i = 0; i < getActivePuzzle().getHeight(); i++) {
      for (int j = 0; j < getActivePuzzle().getWidth(); j++) {
        // if clue cell, has to be satisfied
        if (getActivePuzzle().getCellType(i, j) == CellType.CLUE) {
          if (!isClueSatisfied(i, j)) {
            return false;
          }
        }
        if (getActivePuzzle().getCellType(i, j) == CellType.CORRIDOR) {
          if (isLamp(i, j)) {
            if (isLampIllegal(i, j)) {
              return false;
            }
          }
          if (!isLit(i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }


  public boolean isClueSatisfied(int r, int c) {
    //        if (r >= getActivePuzzle().getHeight()  || c >= getActivePuzzle().getWidth()) {throw
    // new IndexOutOfBoundsException();}
    //        if (r < 0  || c < 0) { throw new IndexOutOfBoundsException();}
    //        if (getActivePuzzle().getCellType(r,c) != CellType.CLUE) {throw new
    // IllegalArgumentException();}

    // must be in direct sight of # of lamps = to clue #
    int status = 0;

    if (c + 1 < getActivePuzzle().getWidth()) {
      if (lightLib.get(currentPuzzleIndex)[r][c + 1] == 1) {
        status += 1;
      }
    }

    if (c - 1 >= 0) {
      if (lightLib.get(currentPuzzleIndex)[r][c - 1] == 1) {
        status += 1;
      }
    }

    if (r + 1 < getActivePuzzle().getWidth()) {
      if (lightLib.get(currentPuzzleIndex)[r + 1][c] == 1) {
        status += 1;
      }
    }

    if (r - 1 >= 0) {
      if (lightLib.get(currentPuzzleIndex)[r - 1][c] == 1) {
        status += 1;
      }
    }
    return (status == getActivePuzzle().getClue(r, c));
  }


  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }


  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  public void updateObservers() {
    for (ModelObserver o : observers) {
      o.update(this);
    }
  }


  public boolean isClueOver(int r, int c) {
    int status = 0;

    if (c + 1 < getActivePuzzle().getWidth()) {
      if (lightLib.get(currentPuzzleIndex)[r][c + 1] == 1) {
        status += 1;
      }
    }

    if (c - 1 >= 0) {
      if (lightLib.get(currentPuzzleIndex)[r][c - 1] == 1) {
        status += 1;
      }
    }

    if (r + 1 < getActivePuzzle().getWidth()) {
      if (lightLib.get(currentPuzzleIndex)[r + 1][c] == 1) {
        status += 1;
      }
    }

    if (r - 1 >= 0) {
      if (lightLib.get(currentPuzzleIndex)[r - 1][c] == 1) {
        status += 1;
      }
    }
    return status > getActivePuzzle().getClue(r, c);
  }


}
