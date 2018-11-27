import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ImageUtils {

    public static List<ImageDataset> readImages(List<String> images, int imageHeight, int imageWidth) {
        List<ImageDataset> result = new ArrayList<>();
        images.forEach(i -> {
            try {
                final BufferedImage image = ImageIO.read(new File(i));

                if (image.getHeight() != imageHeight && image.getWidth() != imageWidth) {
                    throw new RuntimeException("Incorrect image");
                }

                ImageDataset dataset = new ImageDataset();

                for (int j = 0; j < imageHeight; j++) {
                    for (int k = 0; k < imageWidth; k++) {
                        dataset.getData().add(image.getRGB(j, k) == -1 ? 0 : 1);
                    }
                }

                String numberString = i.replace(ImageRecognition.IMAGE_LOCATION, "");
                dataset.setNumber(Integer.valueOf(numberString.substring(0, 1)));

                result.add(dataset);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return result;
    }
}
