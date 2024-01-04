import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isOver = false;
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.printGrid();
        while (!isOver) {
            takeTurn(grid);
            grid.printGrid();
            isOver = isGameOver(grid);
        }
        System.out.println(grid.getGridStatus());
    }

    private static boolean isGameOver(TicTacToeGrid grid) {
        return !grid.getGridStatus().equals("Game not finished");
    }

    public static void takeTurn(TicTacToeGrid grid) {
        int[] coordinates = getCoordinatesFromKeyboard(grid);
        grid.updateGrid(coordinates);
    }

    private static int[] getCoordinatesFromKeyboard(TicTacToeGrid grid) {
        int[] coordinates = new int[2];
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            if (isProperlyFormattedInput(input)) {
                coordinates[0] = Character.getNumericValue(input.charAt(0));
                coordinates[1] = Character.getNumericValue(input.charAt(2));
                if (!grid.isOccupied(coordinates)) {
                    isValidInput = true;
                } else {
                    System.out.println("This cells is occupied! Choose another one!");
                }
            } else {
                printError(input, grid);
            }}
        return coordinates;
    }

    private static boolean isProperlyFormattedInput(String input) {
        return input.matches("\\d \\d") && bothCoordinateValuesAreBetween1And3(input);
    }

    private static void printError(String input, TicTacToeGrid ticTacToeGrid) {
        if (!stringHasTwoValues(input)) {
            System.out.println("You should enter 2 numbers from 1 to 3!");
        } else if (!bothCharsAreNumbers(input)) {
            System.out.println("You should enter numbers!");
        } else if (!bothCoordinateValuesAreBetween1And3(input)) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (ticTacToeGrid.isOccupied(new int[]{Character.getNumericValue(input.charAt(0)),
                Character.getNumericValue(input.charAt(2))})) {
            System.out.println("This cells is occupied! Choose another one!");
        }
    }

    private static boolean stringHasTwoValues(String input) {
        return input.split("\\s+").length == 2;
    }

    private static boolean bothCharsAreNumbers(String input) {
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(2);
        return Character.isDigit(firstChar) && Character.isDigit(secondChar);
    }

    private static boolean bothCoordinateValuesAreBetween1And3(String input) {
        int firstNum = Character.getNumericValue(input.charAt(0));
        int secondNum = Character.getNumericValue(input.charAt(2));
        return firstNum >= 1 && firstNum <= 3 && secondNum >= 1 && secondNum <=3;
    }


}