package ${package}.io;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileUtils {
    private FileUtils() {}

    public static String read(String classPath) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
