import java.util.ArrayList;
import java.util.List;

public class ImageDataset {

    private List<Integer> data;

    public ImageDataset() {
        this.data = new ArrayList<>(DatasetGenerator.IMAGE_HEIGHT * DatasetGenerator.IMAGE_WIDTH);
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(final List<Integer> data) {
        this.data = data;
    }
}
