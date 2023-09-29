import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isOver = false;
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.printGrid();

        while (!isOver) {
            takeTurn(grid);
            String gameState = grid.getGridStatus();
            grid.printGrid();
            switch (gameState) {
                case "X wins":
                case "O wins":
                case "Draw":
                    isOver = true;
                    System.out.println(gameState);
                    break;
            }
        }
    }

    public static void takeTurn(TicTacToeGrid grid) {
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
            if (grid.isOccupied(coordinates)) {
                System.out.println("This cells is occupied! Choose another one!");
                continue;
            }
            isValidInput = true;
        }
        // update the grid with the coordinates
        grid.updateGrid(coordinates);
    }
}