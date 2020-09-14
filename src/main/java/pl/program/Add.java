package pl.program;


import pl.program.consoleColors.ConsoleColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Add {

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String decisionHolder = "";
        List<String> newTaskContainer = new ArrayList<>();
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "\nPress any button to start writing task, quit - to quit" + ConsoleColors.RESET);

        while (!decisionHolder.equals("quit")) {

            System.out.println(ConsoleColors.YELLOW_BOLD + "\nPlease add task description" + ConsoleColors.RESET);
            newTaskContainer.add(scanner.nextLine());

            System.out.println(ConsoleColors.YELLOW_BOLD + "Please add task due date" + ConsoleColors.RESET);
            newTaskContainer.add(scanner.nextLine());

            System.out.println(ConsoleColors.YELLOW_BOLD + "Is your task important true/false" + ConsoleColors.RESET);
            newTaskContainer.add(scanner.nextLine());

            checkIfSaveAndSave(newTaskContainer);
            newTaskContainer.clear();

            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "\nPress any button to start writing task, quit - to quit" + ConsoleColors.RESET);
            decisionHolder = scanner.nextLine();

        }
    }

    private static void checkIfSaveAndSave(List<String> newTaskContainer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + newTaskContainer.toString() + " SAVE? [Y/N]" + ConsoleColors.RESET);
        String decision = scanner.next().toUpperCase();

        if (decision.equals("Y")) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + newTaskContainer.toString() + " RECORD SAVED" + ConsoleColors.RESET);
            newTaskContainer = formatRecord(newTaskContainer);
            newTaskContainer.addAll(TaskList.getTasks());
            Save.savingToFile(newTaskContainer);
        } else if (decision.equals("N")) {
            System.out.println(ConsoleColors.RED_BOLD + "RECORD ERASED" + ConsoleColors.RESET);
        } else {
            System.out.println("WRONG ANSWER, CLEARING...");
        }
    }

    private static List formatRecord(List<String> newTaskContainer) {
        List<String> formattedList = new ArrayList<>();
        formattedList.add(newTaskContainer.get(0) + " " + newTaskContainer.get(1) + " " + newTaskContainer.get(2) );
        return formattedList;
    }
}
