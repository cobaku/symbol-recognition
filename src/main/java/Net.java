import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Net {

    private static double LEARNING_RATE = 0.001;

    private List<Double> inputLayer;
    private List<Double> outputLayer;

    public Net(int inputCount, int outputCount) {
        for (int i = 0; i < inputCount; i++) {
            inputLayer.add(ThreadLocalRandom.current().nextDouble());
        }

        for (int i = 0; i < outputCount; i++) {
            outputLayer.add(ThreadLocalRandom.current().nextDouble());
        }
    }

    public NeuroOut train(List<ImageDataset> datasets) {
        return null;
    }

    public void observe(List<ImageDataset> datasets) {

    }

    public List<Double> predict(List<ImageDataset> datasets) {
        return Collections.emptyList();
    }
}
