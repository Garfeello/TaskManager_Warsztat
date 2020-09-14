package pl.program;

import pl.program.consoleColors.ConsoleColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskList {


    public static void  printTasks() {
        System.out.println(ConsoleColors.GREEN_BOLD + "Printing list... \n" + ConsoleColors.RESET);

        for (int i = 0; i < getTasks().size(); i++) {
            System.out.println(i + ". " + getTasks().get(i));
        }

        System.out.println(ConsoleColors.GREEN_BOLD + "\nList printed... " + ConsoleColors.RESET);
    }

    public static List getTasks() {
        List<String> recordContainer = new ArrayList<>();
        Path tasks = Paths.get("tasks.csv");

        try {
            recordContainer.addAll(Files.readAllLines(tasks));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordContainer;
    }

}
