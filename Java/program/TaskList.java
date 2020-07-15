package program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskList<S> {

    public static void main(String[] args) {

        //list(null);
    }

    public static String[] list(String[] values) {

        Path tasks = Paths.get("tasks.csv");

        String[] listOfRecords = new String[0]; // glowna tabela z wartosciami

        System.out.println(ConsoleColors.GREEN_BOLD + "Printing list... \n" + ConsoleColors.RESET);

        try{
            int counter = 0;
            for (String value : Files.readAllLines(tasks)){

                listOfRecords = Arrays.copyOf(listOfRecords, listOfRecords.length + 1);
                listOfRecords[listOfRecords.length - 1] = value;   // przypisuje do tabeli

                System.out.println(counter + ". " + listOfRecords[counter]); // drukuje oznaczenie miejsca na którym znajduje sie rekord

                counter++; // liczy miejsca
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(ConsoleColors.GREEN_BOLD + "\nList printed... " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Press enter to continue" + ConsoleColors.RESET);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return listOfRecords;
    }

}
