package pkg.GameLogic;

import java.util.Collection;

public class Cell {
    private int data;
    private Collection<Cell> row;
    private Collection<Cell> column;
    private Collection<Cell> box;
    private Cell nextCell;

    public Cell(int value) {
        this.data = value;
    }

    public void setValue(int value) {
        this.data = value;
    }

    public void setRowNeighbors(Collection<Cell> rowNeighbors) {
        this.row = rowNeighbors;
    }

    public void setColumnNeighbors(Collection<Cell> columnNeighbors) {
        this.column = columnNeighbors;
    }

    public void setBoxNeighbors(Collection<Cell> boxNeighbors) {
        this.box = boxNeighbors;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public int getData() {
        return data;
    }

    public Collection<Cell> getRowNeighbors() {
        return row;
    }

    public Collection<Cell> getColumnNeighbors() {
        return column;
    }

    public Collection<Cell> getBoxNeighbors() {
        return box;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public boolean isEmpty() {
        return data == 0;
    }


}
