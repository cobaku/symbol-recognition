public class ImageRecognition {

    public static void main(String[] args) {
        final Net net = new Net();
        net.train();
        net.predict(DummyDataset.E);
    }
}
