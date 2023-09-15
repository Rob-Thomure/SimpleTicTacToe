import java.util.Objects;

public class CellStatusBlank implements CellStatus {
    private char cellValue;

    public CellStatusBlank() {
        cellValue = ' ';
    }

    @Override
    public CellStatus setStatus(char ch) {
        return Character.toUpperCase(ch) == 'X' ? new CellStatusX() : new CellStatusO();
    }

    @Override
    public String toString() {
        return String.valueOf(cellValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellStatusBlank that = (CellStatusBlank) o;
        return cellValue == that.cellValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellValue);
    }
}
