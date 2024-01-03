public class TicTacToeGrid {
    private final char[][] grid;
    private char playerTurn;
    private String gridStatus;

    public TicTacToeGrid() {
        this.grid = createGrid();
        this.playerTurn = 'X';
        this.gridStatus = "Game not finished";
    }

    private char[][] createGrid() {
        return new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    public void printGrid() {
        System.out.println("---------");
        for (char[] row : grid) {
            System.out.print("| ");
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void updateGrid(int[] coordinates) {
        grid[coordinates[0] - 1][coordinates[1] - 1] = playerTurn;
        this.gridStatus = new GridState().setGridState(this.grid);
        changePlayerTurn();
    }

    public boolean isOccupied(int[] coordinates) {
        return grid[coordinates[0] - 1][coordinates[1] - 1] == 'X' ||
                grid[coordinates[0] - 1][coordinates[1] - 1] == 'O';
    }

    public String getGridStatus() {
        return gridStatus;
    }

    private void changePlayerTurn() {
        playerTurn = playerTurn == 'X' ? 'O' : 'X';
    }

}
