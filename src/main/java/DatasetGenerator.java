import java.io.File;
import java.util.List;

public class DatasetGenerator {

    public static String IMAGE_LOCATION = "/home/cobaku/Iate/ne2/src/main/resources/data/templates";

    public static void main(String[] args) {

        final List<String> files = FileUtils.listFilesForFolder(new File(IMAGE_LOCATION));
        System.out.printf("done");
    }


}
