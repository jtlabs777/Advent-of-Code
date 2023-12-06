import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Data\\input.txt");
        Scanner scanner = new Scanner(file);
        //create a boolean called gFlag
        boolean gFlag = false;
        //create an ArrayList of type integer called legitGames
        ArrayList<Integer> legitGames = new ArrayList<>();
        //declare integer of type sum
        int sum;
        //instantiate class called GameValidator
        GameValidator gameValidator = new GameValidator();


        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            //separate Game #: rest of text and store in array called placeholder (localVar)
            String[] placeholder = text.split(": ");
            //parse game number from placeholder and store in integer called gameId (localVar;
            int gameId = Integer.valueOf(placeholder[0].split(" ")[1]);

            //split each set in game by colon and store in array called gameSets (localVar)
            String[] gameSets = placeholder[1].split(";");
            //create a for loop to loop though gameSets and passes each set into the function isPossible();
            for (String set : gameSets) {
                // create a function isPossible that takes a String that calculates if game is possible and returns true or false and assigns it to gFlag
                if (gFlag = gameValidator.isPossible(set)) {
                    continue;
                } else {
                    //if gflag is false, break loop
                    break;
                }
            }


            //if gflag is true then store gamId into integer array called legitGames, the game is legit.
            if (gFlag)  legitGames.add(gameId);

        }
         scanner.close();
        //add up total of legitGames and assign to sum
        sum = legitGames.stream().mapToInt(Integer::intValue).sum();
        //print out total
        System.out.println(sum);
    }
}