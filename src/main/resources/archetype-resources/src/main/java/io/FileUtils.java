package ${package}.io;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.stream.Collectors;

public class FileUtils {
    private FileUtils() {}

    public static void writeFile(String directoryPath, String filename, String contents) {
        try {
            File directory = new File(directoryPath);
            directory.mkdirs();

            File file = new File(directory, filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(contents);
            printStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readClasspathResource(String classPath) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
