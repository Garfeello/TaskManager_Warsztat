package pl.program;

import pl.program.consoleColors.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n--- TASK MANAGER 1.3 ---");
        while (true) menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN_BOLD + "\nPlease select an number:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD + "+ --Actions-- +" + ConsoleColors.RESET);
        System.out.println(
                " 1. List\n" +
                        " 2. Add\n" +
                        " 3. Remove\n" +
                        " 4. Delete all\n" +
                        ConsoleColors.RED_BOLD + " 5. exit" + ConsoleColors.RESET
        );
        System.out.println(ConsoleColors.BLUE_BOLD + "+ ----------- +" + ConsoleColors.RESET);

        int selection = 0;
        try {
            selection = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Write a number !" + ConsoleColors.RESET);
        }

        switch (selection) {
            case 1 -> TaskList.printTasks();
            case 2 -> Add.add();
            case 3 -> Remove.remove();
            case 4 -> Remove.deleteAll();
            case 5 -> exit();
            default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid selection" + ConsoleColors.RESET);
        }
    }

    private static void exit() {
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Exitting...");
        System.exit(0);
    }

}
