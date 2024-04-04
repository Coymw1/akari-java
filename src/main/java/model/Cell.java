package model;
public class Cell {

    private int row;
    private int column;
    private Cell toLeft;
    private Cell toRight;
    private Cell below;
    private Cell above;
    public Cell(int r, int c) {
        row = r;
        column = c;
    }


    public int getColumn() {return column;}
    public int getRow() {return row;}
    public void checkSurroundings() {

    }
}
