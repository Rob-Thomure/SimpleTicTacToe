import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char player = 'X';
        boolean isOver = false;
        char[][] grid = createGrid();
        printGrid(grid);

        while (!isOver) {
            takeTurn(grid, player);
            String gameState = checkState(grid);
            printGrid(grid);
            switch (gameState) {
                case "X wins":
                case "O wins":
                case "Draw":
                    isOver = true;
                    System.out.println(gameState);
                    break;
                default:
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
            }
        }
    }

    public static char[][] createGrid() {
        return new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    public static void printGrid(char[][] grid) {
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

    public static boolean checkFor3InRow(char[][] grid, char player) {
        for (char[] row : grid) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFor3InColumn(char[][] grid, char player) {
        return grid[0][0] == player && grid[1][0] == player && grid[2][0] == player ||
                grid[0][1] == player && grid[1][1] == player && grid[2][1] == player ||
                grid[0][2] == player && grid[1][2] == player && grid[2][2] == player;

    }

    public static boolean checkFor3InDiagonal(char[][] grid, char player) {
        return grid[0][0] == player && grid[1][1] == player && grid[2][2] == player ||
                grid[0][2] == player && grid[1][1] == player && grid[2][0] == player;
    }

    public static boolean checkForEmptyCells(char[][] grid) {
        for (char[] row : grid) {
            for (char column : row) {
                if (column == '_' || column == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForInvalidTurns(char[][] grid) {
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

    public static String checkState(char[][] grid) {
        boolean is3StraightX = checkFor3InRow(grid, 'X') || checkFor3InColumn(grid, 'X') ||
                checkFor3InDiagonal(grid, 'X');
        boolean is3StraightO = checkFor3InRow(grid, 'O') || checkFor3InColumn(grid, 'O') ||
                checkFor3InDiagonal(grid, 'O');
        boolean isInvalidTurns = checkForInvalidTurns(grid);
        boolean isEmptyCells = checkForEmptyCells(grid);
        if (is3StraightX && is3StraightO || isInvalidTurns) {
            return "Impossible";
        } else if (is3StraightX) {
            return "X wins";
        } else if (is3StraightO) {
            return "O wins";
        } else if (isEmptyCells) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    public static char[][] takeTurn(char[][] grid, char player) {
        int[] coordinates = new int[2];
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            char first = input.charAt(0);
            char second = input.charAt(2);
            // check if numbers
            if (!Character.isDigit(first) || !Character.isDigit(second)) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                coordinates[0] = Character.getNumericValue(first);
                coordinates[1] = Character.getNumericValue(second);
            }
            // check if between 1 and 3
            if (coordinates[0] < 1 || coordinates[0] > 3 || coordinates[1] < 1 || coordinates[1] > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            // check if coordinates are occupied
            if (grid[coordinates[0] - 1][coordinates[1] - 1] == 'X' ||
                    grid[coordinates[0] - 1][coordinates[1] - 1] == 'O') {
                System.out.println("This cells is occupied! Choose another one!");
                continue;
            }
            isValidInput = true;
        }
        // update the grid with the coordinates
        grid[coordinates[0] - 1][coordinates[1] - 1] = player;
        return grid;
    }
}