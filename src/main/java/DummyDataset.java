import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public abstract class DummyDataset {

    public enum SymbolName {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        A,
        B,
        C,
        D,
        E;

        public static SymbolName byNumber(int number) {
            return SymbolName.values()[number];
        }
    }

    public static boolean[] ZERO = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    public static boolean[] ONE = {
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true
    };

    public static boolean[] TWO = {
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    public static boolean[] THREE = {
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true
    };

    public static boolean[] FOUR = {
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true
    };

    public static boolean[] FIVE = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true
    };

    public static boolean[] A = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true
    };

    public static boolean[] B = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, false,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    public static boolean[] C = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    public static boolean[] D = {
            true, true, true, true, false,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    public static boolean[] E = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    public static final Map<SymbolName, boolean[]> DATASET = new HashMap<>();

    static {
        DATASET.put(SymbolName.ZERO, ZERO);
        DATASET.put(SymbolName.ONE, ONE);
        DATASET.put(SymbolName.TWO, TWO);
        DATASET.put(SymbolName.THREE, THREE);
        DATASET.put(SymbolName.FOUR, FOUR);
        DATASET.put(SymbolName.FIVE, FIVE);
        DATASET.put(SymbolName.A, A);
        DATASET.put(SymbolName.B, B);
        DATASET.put(SymbolName.C, C);
        DATASET.put(SymbolName.D, D);
        DATASET.put(SymbolName.E, E);
    }
}
