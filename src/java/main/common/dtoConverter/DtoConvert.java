package common.dtoConverter;

import static common.dtoConverter.FileUtils.getFileInputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DtoConvert {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Convert json file to dto using TypeReference.
     *
     * @param typeReference TypeReference - target
     * @param filePath      - source
     * @param failOnUnknown true if should fail if unknown property
     * @param <T>           T any type suitable for deserialization, list, map, dto
     * @return T
     */
    public static <T> T jsonFileToDto(TypeReference<T> typeReference, String filePath, boolean failOnUnknown) {
        ObjectMapper dtoObjectMapper = new ObjectMapper();
        dtoObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknown);
        try (InputStream inputStream = getFileInputStream(filePath, DtoConvert.class)) {
            return dtoObjectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            LOGGER.catching(e);
        }
        return (T) new Object();
    }

    /**
     * Read json file as dro using Class.
     *
     * @param configClass Class - target
     * @param filePath    - file source
     * @param <T>         T any type suitable for deserialization, list, map, dto
     * @return T
     */
    public static <T> T jsonFileToDto(Class<T> configClass, String filePath, boolean failOnUnknown) {
        ObjectMapper dtoObjectMapper = new ObjectMapper();
        dtoObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknown);
        return readStream(configClass, filePath, dtoObjectMapper);
    }

    protected static <T> T readStream(Class<T> configClass, String filePath, ObjectMapper dtoObjectMapper) {
        try (InputStream inputStream = getFileInputStream(filePath, configClass)) {
            return dtoObjectMapper.readValue(inputStream, configClass);
        } catch (IOException e) {
            LOGGER.catching(e);
        }
        return null;
    }

}
