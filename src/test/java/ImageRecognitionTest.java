import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageRecognitionTest {

    @Test
    public void testImageRecognition() {
        final Net net = new Net();
        net.train();

        assertEquals(net.predictSymbol(DummyDataset.ZERO), DummyDataset.SymbolName.ZERO);
        assertEquals(net.predictSymbol(DummyDataset.ONE), DummyDataset.SymbolName.ONE);
        assertEquals(net.predictSymbol(DummyDataset.TWO), DummyDataset.SymbolName.TWO);
        assertEquals(net.predictSymbol(DummyDataset.THREE), DummyDataset.SymbolName.THREE);
        assertEquals(net.predictSymbol(DummyDataset.FOUR), DummyDataset.SymbolName.FOUR);
        assertEquals(net.predictSymbol(DummyDataset.FIVE), DummyDataset.SymbolName.FIVE);
        assertEquals(net.predictSymbol(DummyDataset.A), DummyDataset.SymbolName.A);
        assertEquals(net.predictSymbol(DummyDataset.B), DummyDataset.SymbolName.B);
        assertEquals(net.predictSymbol(DummyDataset.C), DummyDataset.SymbolName.C);
        assertEquals(net.predictSymbol(DummyDataset.D), DummyDataset.SymbolName.D);
        assertEquals(net.predictSymbol(DummyDataset.E), DummyDataset.SymbolName.E);

        net.printTotalError();
    }
}
