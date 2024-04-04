package model;

import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {

    private List<Cell> avoid;
    private List<Cell> required;
    private List<Cell> clueCells;
    private PuzzleImpl puzzleToSolve;
    private ModelImpl solver;
    public PuzzleSolver(PuzzleImpl puzzleToBeSolved) {
        avoid = new ArrayList<>();
        required = new ArrayList<>();
        clueCells = new ArrayList<>();
        this.puzzleToSolve = puzzleToBeSolved;
        PuzzleLibraryImpl singlePuzzleLib = new PuzzleLibraryImpl();
        singlePuzzleLib.addPuzzle(puzzleToBeSolved);
        solver = new ModelImpl(singlePuzzleLib);
    }


    /*

    Class implementation:
    The idea behind ModelImpl is that we need a class to handle everything that goes into solving a puzzle, (user input and tracking the state of the puzzle)
    PuzzleSolver is similar, the only major difference being the solution process is automated
    ModelImpl needed to keep track of multiple puzzles stored in a puzzle library, but PuzzleSolver only needs to handle one puzzle at a time
    Since we are going more into detail, we use the Cell object to keep track of each cells position, and important info about their surroundings
    If we store information in cell objects, we won't have to loop through the entire array as much
    This means that we will have to reimplement some of the puzzle logic from ModelImpl



    Algorithm steps:
    1. Loop through 2d array and place a lamp directly next to each clue cell (unless the cell is a 0)
    - if a cell is not a "0" or a "4", we need to also check if there are any walls around the cell, because this may help us determine any more required lamp cells
    - (if a "1" cell is surrounded by 3 walls, then the remaining open lamp spot is required)
    2. Loop through the array again, placing a lamp on any cell that is not currently lit
    - All 4 and 0 clue cells should be satisfied by this point, so now we focus on satisfying all other clue cells
    - Add all cells surrounding "4" cells to required, and add all cells surrounding "0" cells to avoid
    3. Loop through array until we reach a cell with more lamps than necessary
    - remove 1 of 4 surrounding lamps. if this removal causes a previously satisfied lamp to be unsatsfied, add it back and add that cell to required
    - keep removing lamps until the current clue is satisfied, and do this for all unsatisfied clues in the puzzle
    4. Loop through the array again, adding a lamp to any cell that is not currently lit, as long as that cell is not one we are avoiding
    - if the puzzle is still unsatisfied after this point, there must be an illegally placed lamp
    5. loop through the array one final time, and checking each illegally placed lamp
    - first we remove the lamp, but add it back if it is required to satisfy the puzzle






    Keep in mind:
    Since all we are doing is automating the solving process, we can use a ModelImpl to gain access to all the methods we will need
    (we won't have to reimplement all of the traversing logic)

    We know that all clue cells with a "4" MUST be surrounded by lamps. We also know that the opposite goes for "0" clue cells.
    - We need some way to keep track of guaranteed lamp spots, spots to avoid
    - Remember: 2d array means arr[row][column], so using Point(x,y) to represent cells might get confusing
    - Store each spot in a cell object, and keep track of the cells using lists
    - there can't be any lamps

    Optimal lamp placement in this case means the least amount of lamps placed to solve the puzzle.
    Find all possible lamp placements and pick the smallest (will all possible placements be too many?)



    */
    // TODO: Receives a puzzle and prints the optimal lamp placement. If the puzzle is unsolvable, print that to the console.
    public void solvePuzzle() {

    }

    public void checkCellForRequiredLamps() {

    }

}
