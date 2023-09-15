public interface CellStatus {

    CellStatus setStatus(char ch);

    default void printErrorOccupied() {
        System.out.println("This cells is occupied! Choose another one!");
    }
}
