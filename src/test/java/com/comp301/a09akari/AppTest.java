package com.comp301.a09akari;

import com.comp301.a09akari.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */

  public static int[][] puz = {
          {6, 6, 5, 6, 6, 6},
          {6, 5, 6, 6, 6, 3},
          {6, 6, 6, 6, 6, 6},
          {6, 6, 6, 6, 6, 6},
          {3, 6, 6, 6, 6, 6},
          {6, 2, 6, 6, 6, 6},
          {6, 6, 6, 6, 0, 6},
  };
  public static int[][] dum = {
          {6, 6, 6, 6, 6, 0, 6},
          {2, 6, 6, 6, 5, 6, 6},
          {6, 3, 6, 6, 6, 6, 6},
          {6, 6, 6, 6, 6, 6, 6},
          {6, 6, 6, 6, 6, 4, 6},
          {6, 6, 5, 6, 6, 6, 5},
          {6, 2, 6, 6, 6, 6, 6},
  };
  @Test
  public void lampTest() {

    PuzzleLibraryImpl pl = new PuzzleLibraryImpl();
    Puzzle p = new PuzzleImpl(dum);
    pl.addPuzzle(p);
    ModelImpl m = new ModelImpl(pl);

    m.isClueSatisfied(1,0);
    m.addLamp(0,0);
    m.isClueSatisfied(1,0);
    m.isClueSatisfied(1,0);
    m.addLamp(1,1);
    m.isClueSatisfied(1,0);
    m.addLamp(2,0);
    m.isClueSatisfied(1,0);
    m.removeLamp(0,0);
    m.isClueSatisfied(1,0);
    m.isClueSatisfied(1,0);
    m.removeLamp(1,1);
    m.isClueSatisfied(1,0);
    m.addLamp(1,2);
    assertFalse(m.isClueSatisfied(1, 0));
  }

  @Test
  public void lampTest2() {

    PuzzleLibraryImpl pl = new PuzzleLibraryImpl();
    Puzzle p = new PuzzleImpl(puz);
    pl.addPuzzle(p);
    ModelImpl m = new ModelImpl(pl);

    m.addLamp(3,0);
    m.resetPuzzle();
    assertFalse(m.isLamp(3,0));
  }

}
