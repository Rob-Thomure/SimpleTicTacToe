import java.util.Objects;

public class CellStatusX implements CellStatus {
    private char cellValue;

    public CellStatusX() {
        cellValue = 'X';
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
        CellStatusX that = (CellStatusX) o;
        return cellValue == that.cellValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellValue);
    }
}
