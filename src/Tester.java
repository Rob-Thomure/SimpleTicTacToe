public class Tester {

    public static void main(String[] args) {
        TicTacToeGrid ticTacToeGrid = new TicTacToeGrid();
        ticTacToeGrid.printTicTacToeGrid();
        ticTacToeGrid.setCellStatus(2, 2, 'X');
        ticTacToeGrid.printTicTacToeGrid();

    }

}
