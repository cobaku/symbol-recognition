public class ImageRecognition {

    public static String IMAGE_LOCATION = "/home/cobaku/Iate/ne2/src/main/resources/data/templates/";
    public static int IMAGE_HEIGHT = 10;
    public static int IMAGE_WIDTH = 10;

    public static int OUTPUT_LAYER = 7;
    public static int INPUT_LAYER = 100;

    public static void main(String[] args) {

       /* final List<String> files = FileUtils.listFilesForFolder(new File(IMAGE_LOCATION))
                .stream()
                .map(v -> IMAGE_LOCATION + v)
                .collect(Collectors.toList());

        final List<ImageDataset> imageDatasets = ImageUtils.readImages(files, IMAGE_HEIGHT, IMAGE_WIDTH);

        final Net net = new Net(INPUT_LAYER, OUTPUT_LAYER);
        net.observe(imageDatasets);*/

        final Net net = new Net();
        net.train();
    }
}
