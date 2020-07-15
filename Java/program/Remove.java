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

    public static void main(String[] args) {
        //remove();
    }

    public static void remove(){
        Scanner scanner = new Scanner(System.in);

        System.out.println( ConsoleColors.RED_BOLD_BRIGHT  + "Removing tasks loading list..." + ConsoleColors.RESET);

        String[] valuesToRemove = new String[0];        //
        valuesToRemove = TaskList.list(valuesToRemove); // pobrana tabelka z klasy List

        System.out.println(ConsoleColors.RED_BOLD + "Type in NUMBER in order to remove record, quit - to save" + ConsoleColors.RESET);

        String decisionHolder = scanner.next();

        do {
            try {
                int decHolder_NumericValue = Integer.parseInt(decisionHolder);  // wybor pliku do usuniecia

                for (int i = 0; i < valuesToRemove.length; i ++){   //petla do usuwania rekordow
                    if (decHolder_NumericValue == i){

                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + valuesToRemove[i] + "  --RECORD REMOVED!" + ConsoleColors.RESET);
                        valuesToRemove = ArrayUtils.remove(valuesToRemove, i);      // usuwanie rekordu

                        System.out.println(ConsoleColors.GREEN_BOLD + "Remaining records:" + ConsoleColors.RESET);
                        for (int j = 0; j < valuesToRemove.length; j++){
                            System.out.println(j + ". " + valuesToRemove[j]);  // pokazuje pozostale pozycje.
                        }
                    }
                }
                System.out.println(ConsoleColors.RED_BOLD + "Type in NUMBER in order to remove record, quit - to save" + ConsoleColors.RESET);
                decisionHolder = scanner.next(); //czeka na akcje zeby nie stworzyc nieskonczonej petli z for

            } catch (NumberFormatException e) {
                if (decisionHolder.equals("quit")){
                    System.out.print("");
                } else {
                    System.out.println("It has to be a number !");
                    decisionHolder = scanner.next(); //czeka na akcje zeby nie stworzyc nieskonczonej petli w przypadku kiedy wartosc nie jest cyfra
                }
            } catch (ArrayIndexOutOfBoundsException ex){
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "RECORD DOES NOT EXIST !");
            }

        } while (!decisionHolder.equals("quit"));

        saveList(valuesToRemove);
    }

    public static void saveList(String[] valuesToRemove) {
        Path main = Paths.get("tasks.csv");
        List<String> outList = new ArrayList<>();

        for (String value : valuesToRemove){
            boolean add = outList.add(value);
        }

        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "SAVING..." + ConsoleColors.RESET);

        try {
            Files.write(main, outList);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "SAVED !\n" +
                    ConsoleColors.CYAN_BOLD_BRIGHT + "Press enter to continue" + ConsoleColors.RESET
            );
            System.in.read();
        } catch (IOException e){
            System.out.println("Unable to save file");
        }


        // System.out.println(Arrays.toString(valuesToRemove) + valuesToRemove.length);
    }
}
