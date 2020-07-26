package program;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remove {


    public static void downloadValues() {

        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Removing tasks loading list..." + ConsoleColors.RESET);

        String[] valuesToRemove = new String[0];             //
        valuesToRemove = TaskList.printTasks(); // pobrana tabelka z metody List

        System.out.println(ConsoleColors.RED_BOLD + "Type in NUMBER in order to remove record, quit - to save" + ConsoleColors.RESET);

        valuesToRemove = deletionOfValues(valuesToRemove);

        saveOfValues(valuesToRemove);
    }

    public static String[] deletionOfValues(String[] valuesToRemove) {

        Scanner scanner = new Scanner(System.in);

        String decisionHolder = scanner.next(); // bd wybieral plik do usuniecia, wychodzi quitem dlatego parsuje ponizej

        do {
            try {
                int decHolder_NumericValue = Integer.parseInt(decisionHolder);

                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + valuesToRemove[decHolder_NumericValue] + "  --RECORD REMOVED!" + ConsoleColors.RESET);
                valuesToRemove = ArrayUtils.remove(valuesToRemove, decHolder_NumericValue);     // usuwanie rekordu

                System.out.println(ConsoleColors.GREEN_BOLD + "Remaining records:" + ConsoleColors.RESET);
                for (int i = 0; i < valuesToRemove.length; i++) {
                    System.out.println(i + ". " + valuesToRemove[i]);  // pokazuje pozostale pozycje.
                }

                System.out.println(ConsoleColors.RED_BOLD + "Type in NUMBER in order to remove record, quit - to save" + ConsoleColors.RESET);
                decisionHolder = scanner.next(); //czeka na akcje aby wybrac next record.

            } catch (NumberFormatException e) {
                if (decisionHolder.equals("quit")) {
                    System.out.print("");
                } else {
                    System.out.println("It has to be a number !");
                    decisionHolder = scanner.next(); //czeka na akcje zeby nie stworzyc nieskonczonej petli w przypadku kiedy wartosc nie jest cyfra
                }

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "RECORD DOES NOT EXIST !");
                decisionHolder = scanner.next();
            }

        } while (!decisionHolder.equals("quit"));

        return valuesToRemove;
    }

    public static void saveOfValues(String[] valuesToRemove) {
        Path main = Paths.get("tasks.csv");
        List<String> outList = new ArrayList<>();

        for (String value : valuesToRemove) {
            outList.add(value);
        }

        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "SAVING..." + ConsoleColors.RESET);

        try {
            Files.write(main, outList);
            System.out.println(
                    ConsoleColors.GREEN_BOLD_BRIGHT + "SAVED !\n" +
                            ConsoleColors.CYAN_BOLD_BRIGHT + "Press enter to continue" + ConsoleColors.RESET
            );
            System.in.read();

        } catch (IOException e) {
            System.out.println("Unable to save file");
        }

    }
}

