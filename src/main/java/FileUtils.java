import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FileUtils {

    public static List<String> listFilesForFolder(final File folder) {
        List<String> files = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getName());
            }
        }

        return files;
    }
}
