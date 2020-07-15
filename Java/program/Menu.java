package program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        while (true){
            menu.menu();
        }
    }

    public static void menu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.GREEN_BOLD + "\nPlease select an option:\n" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD  +"+ --Actions-- +" + ConsoleColors.RESET);
        System.out.println(
                        " 1. List\n" +
                        " 2. Add\n" +
                        " 3. Remove\n" +
                        " 4. exit"
        );

        System.out.println(ConsoleColors.BLUE_BOLD + "+ ----------- +" + ConsoleColors.RESET);

        int selection = 0;

        try {
            selection = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Write a number !" + ConsoleColors.RESET);
        }

        switch (selection){
            case 1:
                List.list();
                break;
            case 2:
                Add.add();
                break;
            case 3:
                Remove.remove();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid selection" + ConsoleColors.RESET);
                break;
        }
    }

    public static void exit(){
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Exitting...");
        System.exit(0);
    }
}
