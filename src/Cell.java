public class Cell {
    private CellStatus cellStatus;
    private final int row;
    private final int column;

    public Cell(int row, int column) {
        this.cellStatus = new CellStatusBlank();
        this.row = row;
        this.column = column;
    }

    public String getCellStatus() {
        return cellStatus.toString();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setCellStatus(char ch) {
        cellStatus = cellStatus.setStatus(ch);
    }



    @Override
    public String toString() {
        return "Cell{" +
                "state=" + cellStatus +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
