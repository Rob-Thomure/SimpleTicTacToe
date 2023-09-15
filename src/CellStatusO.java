import java.util.Objects;

public class CellStatusO implements CellStatus {
    private char cellValue;

    public CellStatusO() {
        cellValue = 'O';
    }

    @Override
    public CellStatus setStatus(char ch) {
        printErrorOccupied();
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(cellValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellStatusO that = (CellStatusO) o;
        return cellValue == that.cellValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellValue);
    }

}
