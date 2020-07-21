package program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskList {


    public static String[] printTasks() {

        String[] listOfRecords = new String[0]; // glowna tabela z wartosciami

        System.out.println(ConsoleColors.GREEN_BOLD + "Printing list... \n" + ConsoleColors.RESET);

        listOfRecords = getTasks( listOfRecords);
        for (int i = 0; i < listOfRecords.length; i++ ) {
            System.out.println(i + ". " + listOfRecords[i]);
        } // drukuje rekordy

        System.out.println(ConsoleColors.GREEN_BOLD + "\nList printed... " + ConsoleColors.RESET);

        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Press enter to continue" + ConsoleColors.RESET);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfRecords;
    }

    public static String[] getTasks(String[] recordContainer) {

        Path tasks = Paths.get("tasks.csv");

        try{
            for (String value : Files.readAllLines(tasks)){
                recordContainer = Arrays.copyOf(recordContainer, recordContainer.length + 1);
                recordContainer[recordContainer.length - 1] = value;   // przypisuje do tabeli
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return recordContainer;
    }

}
