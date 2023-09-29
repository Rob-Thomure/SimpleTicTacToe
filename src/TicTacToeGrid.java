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

    private boolean checkFor3InRow(char player) {
        for (char[] row : grid) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkFor3InColumn(char player) {
        return grid[0][0] == player && grid[1][0] == player && grid[2][0] == player ||
                grid[0][1] == player && grid[1][1] == player && grid[2][1] == player ||
                grid[0][2] == player && grid[1][2] == player && grid[2][2] == player;

    }

    private boolean checkFor3InDiagonal(char player) {
        return grid[0][0] == player && grid[1][1] == player && grid[2][2] == player ||
                grid[0][2] == player && grid[1][1] == player && grid[2][0] == player;
    }

    private boolean checkForEmptyCells() {
        for (char[] row : grid) {
            for (char column : row) {
                if (column == '_' || column == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateGrid(int[] coordinates) {
        grid[coordinates[0] - 1][coordinates[1] - 1] = playerTurn;
        updateGridState();
        changePlayerTurn();
    }

    public boolean isOccupied(int[] coordinates) {
        return grid[coordinates[0] - 1][coordinates[1] - 1] == 'X' ||
                grid[coordinates[0] - 1][coordinates[1] - 1] == 'O';
    }

    private void updateGridState() {
        boolean is3StraightX = checkFor3InRow('X') || checkFor3InColumn('X') ||
                checkFor3InDiagonal('X');
        boolean is3StraightO = checkFor3InRow('O') || checkFor3InColumn('O') ||
                checkFor3InDiagonal('O');
        boolean isInvalidTurns = checkForInvalidTurns();
        boolean isEmptyCells = checkForEmptyCells();
        if (is3StraightX && is3StraightO || isInvalidTurns) {
            gridStatus = "Impossible";
        } else if (is3StraightX) {
            gridStatus = "X wins";
        } else if (is3StraightO) {
            gridStatus = "O wins";
        } else if (isEmptyCells) {
            gridStatus = "Game not finished";
        } else {
            gridStatus = "Draw";
        }
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public boolean checkForInvalidTurns() {
        int xCount = 0;
        int oCount = 0;
        for (char[] row : grid) {
            for (char column : row) {
                if (column == 'X') {
                    xCount++;
                }
                if (column == 'O') {
                    oCount++;
                }
            }
        }
        return Math.abs(xCount - oCount) > 1;
    }

    private void changePlayerTurn() {
        playerTurn = playerTurn == 'X' ? 'O' : 'X';
    }








}
