public class GridState {

    public GridState() {
    }

    public String setGridState(char[][] gameGrid) {
        if (is3StraightX(gameGrid) && is3StraightO(gameGrid) || isInvalidTurns(gameGrid)) {
            return  "Impossible";
        } else if (is3StraightX(gameGrid)) {
            return  "X wins";
        } else if (is3StraightO(gameGrid)) {
            return  "O wins";
        } else if (isEmptyCells(gameGrid)) {
            return  "Game not finished";
        } else {
            return  "Draw";
        }
    }

    private boolean is3StraightX(char[][] gameGrid) {
        return checkFor3InRow('X', gameGrid) || checkFor3InColumn('X', gameGrid) ||
                checkFor3InDiagonal('X', gameGrid);
    }

    private boolean is3StraightO(char[][] gameGrid) {
        return checkFor3InRow('O', gameGrid) || checkFor3InColumn('O', gameGrid) ||
                checkFor3InDiagonal('O', gameGrid);
    }

    private boolean checkFor3InRow(char player, char[][] gameGrid) {
        for (char[] row : gameGrid) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkFor3InColumn(char player, char[][] gameGrid) {
        return gameGrid[0][0] == player && gameGrid[1][0] == player && gameGrid[2][0] == player ||
                gameGrid[0][1] == player && gameGrid[1][1] == player && gameGrid[2][1] == player ||
                gameGrid[0][2] == player && gameGrid[1][2] == player && gameGrid[2][2] == player;

    }

    private boolean checkFor3InDiagonal(char player, char[][] gameGrid) {
        return gameGrid[0][0] == player && gameGrid[1][1] == player && gameGrid[2][2] == player ||
                gameGrid[0][2] == player && gameGrid[1][1] == player && gameGrid[2][0] == player;
    }

    private boolean isInvalidTurns(char[][] gameGrid) {
        int xCount = 0;
        int oCount = 0;
        for (char[] row : gameGrid) {
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

    private boolean isEmptyCells(char[][] gameGrid) {
        for (char[] row : gameGrid) {
            for (char column : row) {
                if (column == '_' || column == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

}
