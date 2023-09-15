import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TicTacToeGrid {
    Cell[][] grid;
    List<Cell> gridList;

    public TicTacToeGrid() {
        this.grid = createTicTacToeGrid();
        this.gridList = create();
    }


    private Cell[][] createTicTacToeGrid() {
        Cell[][] grid = new Cell[3][3];
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                grid[row][column] = new Cell(row + 1, column + 1);
            }
        }
        return grid;
    }

    private List<Cell> create() {
        List<Cell> cells = new ArrayList<>();
        IntStream.rangeClosed(1, 3)
                .forEach(row -> IntStream.rangeClosed(1, 3)
                        .forEach(column -> cells.add(new Cell(row, column))));
        return cells;
    }

    public void printTicTacToeGrid() {
        System.out.println("---------");
        IntStream.rangeClosed(1, 3)
                .forEach(row -> printRow(row));
        System.out.println("---------");
    }

    private void printRow(int row) {
        System.out.print("| ");
        IntStream.rangeClosed(1, 3)
                .forEach(column -> System.out.print(getCell(row, column).getCellStatus() + " "));
        System.out.println("|");
    }

    private Cell getCell(int row, int column) {
        return gridList.stream()
                .filter(cell -> cell.getRow() == row && cell.getColumn() == column)
                .findAny()
                .get();
    }

    public void setCellStatus(int row, int colum, char cellStatus) {
        gridList.stream()
                .filter(cell -> cell.getRow() == row && cell.getColumn() == colum)
                .findAny()
                .get()
                .setCellStatus(cellStatus);
    }
}
