import java.util.List;

public enum NeuroOut {

    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    CANNOT_RECOGNIZE;

    public static NeuroOut getNumberByOut(List<Double> out) {
        return ZERO;
    }

    private Double activate(Double value) {
        return 1 / (1 + Math.exp(-value));
    }

}
