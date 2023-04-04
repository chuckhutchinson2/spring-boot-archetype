package ${package}.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {
    private JsonUtils() {}

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void writeFile(String directoryPath, String filename, List<T> items) {

        try {
            String contents = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);
            FileUtils.writeFile(directoryPath, filename, contents);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> readFile(String filename, Class<T> contentClass) {
        String contents = FileUtils.readFile(filename);

        return readContents(contents, contentClass);
    }

    public static <T> List<T> readClassPathResource(String classpathResourceFilename, Class<T> contentClass) {
        String contents = FileUtils.readClasspathResource(classpathResourceFilename);

        return readContents(contents, contentClass);
    }

    public static <T> T read(String classpathResourceFilename, Class<T> contentClass) {
        String contents = FileUtils.readClasspathResource(classpathResourceFilename);

        return readContent(contents, contentClass);
    }

    public static <T> T readContent(String contents, Class<T> contentClass) {
        try {
            return objectMapper.readValue(contents, contentClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> readContents(String contents, Class<T> contentClass) {
        JavaType type = objectMapper.getTypeFactory().
                constructCollectionType(List.class, contentClass);

        try {
            return objectMapper.readValue(contents, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> copyList(List<T> tS, Class<T> contentClass) {
        try {
            String contents = objectMapper.writeValueAsString(tS);

            JavaType type = objectMapper.getTypeFactory().
                    constructCollectionType(List.class, contentClass);

            return objectMapper.readValue(contents, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T copy(T t, Class<T> contentClass) {
        try {
            String content = objectMapper.writeValueAsString(t);

            return readContent(content, contentClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
