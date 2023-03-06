package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle {
  private final int[][] b;

  public PuzzleImpl(int[][] board) {
    b = board;
  }

  @Override
  public int getWidth() {
    return b[0].length;
  }

  @Override
  public int getHeight() {
    return b.length;
  }

  @Override
  public CellType getCellType(int r, int c) {
    if (r < 0 || r >= getHeight() || c < 0 || c >= getWidth()) {
      throw new IndexOutOfBoundsException();
    }

    int cellNum = b[r][c];
    if (cellNum >= 0 && cellNum <= 4) {
      return CellType.CLUE;
    } else if (cellNum == 5) {
      return CellType.WALL;
    } else if (cellNum == 6) {
      return CellType.CORRIDOR;
    } else {
      return null;
    }
  }

  @Override
  public int getClue(int r, int c) {
    if (r < 0 || r >= getHeight() || c < 0 || c >= getWidth()) {
      throw new IndexOutOfBoundsException();
    }

    int cellNum = b[r][c];
    if (cellNum >= 0 && cellNum <= 4) {
      return cellNum;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
