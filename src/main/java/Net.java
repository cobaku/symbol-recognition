import java.util.ArrayList;
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

    private NeuroOut train(List<ImageDataset> datasets) {
        return null;
    }

    public void observe(List<ImageDataset> datasets) {
        System.out.println("Start training");

    }

    public List<Double> predict(List<Double> dataset) {
        List<Double> result = new ArrayList<>();

        List<Double> inputLayerValues = new ArrayList<>();

        for (int i = 0; i < dataset.size(); i++) {
            inputLayerValues.add(inputLayer.get(i) * dataset.get(i));
        }

        for (int i = 0; i < outputLayer.size(); i++) {
            final Double outputWeight = outputLayer.get(i);
            result.add(inputLayerValues.stream().mapToDouble(iv -> iv * outputWeight).sum());
        }

        return result;
    }
}
