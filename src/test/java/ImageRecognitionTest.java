import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageRecognitionTest {

    @Test
    public void testImageRecognition() {
        final Net net = new Net();
        net.train();

        assertEquals(net.predict(DummyDataset.ZERO), DummyDataset.SymbolName.ZERO);
        assertEquals(net.predict(DummyDataset.ONE), DummyDataset.SymbolName.ONE);
        assertEquals(net.predict(DummyDataset.TWO), DummyDataset.SymbolName.TWO);
        assertEquals(net.predict(DummyDataset.THREE), DummyDataset.SymbolName.THREE);
        assertEquals(net.predict(DummyDataset.FOUR), DummyDataset.SymbolName.FOUR);
        assertEquals(net.predict(DummyDataset.FIVE), DummyDataset.SymbolName.FIVE);
        assertEquals(net.predict(DummyDataset.A), DummyDataset.SymbolName.A);
        assertEquals(net.predict(DummyDataset.B), DummyDataset.SymbolName.B);
        assertEquals(net.predict(DummyDataset.C), DummyDataset.SymbolName.C);
        assertEquals(net.predict(DummyDataset.D), DummyDataset.SymbolName.D);
        assertEquals(net.predict(DummyDataset.E), DummyDataset.SymbolName.E);
    }
}
