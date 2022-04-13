package common.dtoConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileUtils {

    /**
     * Gets an input stream from a file.
     *
     * @param filePath    - path to file
     * @param configClass - loader
     * @return InputStream of located file
     * @throws FileNotFoundException in case if file was not found
     */
    public static InputStream getFileInputStream(String filePath, Class<?> configClass) throws FileNotFoundException {
        InputStream inputStream = configClass.getResourceAsStream(filePath);
        if (inputStream == null) {
            inputStream = new FileInputStream(filePath);
        }
        return inputStream;
    }

}
