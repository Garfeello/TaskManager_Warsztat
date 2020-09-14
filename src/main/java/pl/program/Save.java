package pl.program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Save {

    public static void savingToFile(List<String> newTaskContainer) {
        Path path = Paths.get("tasks.csv");
        try {
            String a = ";";
            Files.write(path, newTaskContainer);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }
    }
}
