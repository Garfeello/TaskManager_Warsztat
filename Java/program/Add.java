package program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static program.TaskList.getTasks;

public class Add {


    public static void add(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Adding tasks, press any button to start writing, quit - to quit" + ConsoleColors.RESET);
        String decisionHolder = scanner.nextLine();

        String[] newTaskContainer = new String[3]; //bd miala tylko 3 elementy - nazwe - date - waznosc

        while (!decisionHolder.equals("quit")) {

            System.out.println(ConsoleColors.YELLOW_BOLD + "\nPlease add task description" + ConsoleColors.RESET);

            newTaskContainer[0] = scanner.nextLine();

            System.out.println(ConsoleColors.YELLOW_BOLD + "Please add task due date" + ConsoleColors.RESET);
            newTaskContainer[1] = scanner.nextLine();

            System.out.println(ConsoleColors.YELLOW_BOLD + "Is your task important true/false" + ConsoleColors.RESET);
            newTaskContainer[2] = scanner.nextLine();

            //zapisywanie do pliku
            zapisywanieDoPliku(newTaskContainer);

            // kontynuacja programu
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "\nPress any button to start writing another task, quit - to quit" + ConsoleColors.RESET);
            decisionHolder = scanner.nextLine();
        }

    }

    public static void zapisywanieDoPliku(String[] newTaskContainer) {

        String[] valuesToAdd = new String[0];   //
        valuesToAdd = getTasks(valuesToAdd);   // pobrana tabelka z Metody List

        Path path1 = Paths.get("tasks.csv");
        List<String> outList = new ArrayList<>();

        //drukuje rekordy dodawanego pliku
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + Arrays.toString(newTaskContainer) + " --SAVING TASK" + ConsoleColors.RESET);

        //zapisuje liste
        for (String value : valuesToAdd) {
            outList.add(value);
        }
        outList.add(newTaskContainer[0] + ", " + newTaskContainer[1] + ", " + newTaskContainer[2]);
        try {
            Files.write(path1, outList);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }
    }

}
