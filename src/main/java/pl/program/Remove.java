package pl.program;

import pl.program.consoleColors.ConsoleColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Remove {

    public static void remove() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Removing tasks loading... " + ConsoleColors.RESET);
        List<String> valuesToRemove = TaskList.getTasks();
        TaskList.printTasks();

        System.out.println(ConsoleColors.RED_BOLD + "Type in NUMBER in order to remove record, quit - to save" + ConsoleColors.RESET);
        while (!scanner.hasNext("quit")) {
            deleteValues(valuesToRemove, scanner);
            System.out.println(ConsoleColors.GREEN_BOLD + "Remaining records:" + ConsoleColors.RESET);
            for (int i = 0; i < valuesToRemove.size(); i++) {
                System.out.println(i + ". " + valuesToRemove.get(i));
            }
        }
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "SAVING..." + ConsoleColors.RESET);
        Save.savingToFile(valuesToRemove);
    }

    private static void deleteValues(List<String> valuesToRemoved, Scanner scanner) {
        try {
            int positionToDelete = scanner.nextInt();
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + valuesToRemoved.get(positionToDelete) + "  --RECORD REMOVED!" + ConsoleColors.RESET);
            valuesToRemoved.remove(positionToDelete);
        } catch (InputMismatchException e) {
            System.out.println("to musi być cyfra !");
            scanner.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("nie ma takiej pozycji");
        }
    }

    public static void deleteAll() {
        Path path = Paths.get("tasks.scv");
        try {
            Files.write(path, new ArrayList<>());
            System.out.println("CLEARED LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

