package model;

import java.util.ArrayList;
import java.util.List;

public class PuzzleLibraryImpl {
  private final List<PuzzleImpl> puzzles;

  public PuzzleLibraryImpl() {
    this.puzzles = new ArrayList<>();
  }

  public void addPuzzle(PuzzleImpl puzzle) {
    if (puzzle == null) {
      throw new IllegalArgumentException("Cannot add null Puzzle to the library");
    }
    puzzles.add(puzzle);
  }

  public PuzzleImpl getPuzzle(int index) {
    return puzzles.get(index);
  }

  public int size() {
    return puzzles.size();
  }
}
