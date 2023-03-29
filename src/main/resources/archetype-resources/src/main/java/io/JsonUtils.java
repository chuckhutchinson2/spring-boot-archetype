package ${package}.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {
    private JsonUtils() {}

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T read(String filename, Class<T> contentClass) {
        String contents = FileUtils.read(filename);

        try {
            return objectMapper.readValue(contents, contentClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> List<T> readList(String filename, Class<T> contentClass) {
        String contents = FileUtils.read(filename);

        JavaType type = objectMapper.getTypeFactory().
                constructCollectionType(List.class, contentClass);

        try {
            return objectMapper.readValue(contents, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
