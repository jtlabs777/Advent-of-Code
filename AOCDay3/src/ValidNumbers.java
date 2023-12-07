import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumbers {

    private static ArrayList<String> input = new ArrayList<>();
    public void printTotalVaidNumbers() throws FileNotFoundException {
        //create a variable int sum = 0
        int sum = 0;
        //Read file
        File file = new File("data\\input.txt");
        Scanner scanner = new Scanner(file);
        //store in global array
        while (scanner.hasNextLine()) {
             input.add(scanner.nextLine());
        }
        scanner.close();
        //loop through array using traditional for, (index = 0)
        for (int index = 0; index < input.size(); index ++) {
            //call retrieveSum to get sum of valid numbers, should take current index as argument
            sum += retrieveSum(index);
        }

        System.out.println(sum);
    }

    private static Integer retrieveSum(int index) {
        //create pattern string [0-9]+
        String pattern = "[0-9]+";
        int sum = 0;
        ArrayList<Integer> total = new ArrayList<>();
        // create matcher string w/ Pattern compile and matcher method on input array
        Matcher mt = Pattern.compile(pattern).matcher(input.get(index));
        //create while statement with mt.find()
        while (mt.find()) {
            //assign number to String number
            String number = mt.group();
            //note start and end indexes
            int start = (mt.start() != 0) ? mt.start() -1 : 0;
            int end = (mt.end() != input.size()) ? mt.end() + 1 : mt.end();
            //if (call validateNumber (start, end, index))
            if (validateNumber(start, end, index)) {
                sum += Integer.valueOf(number);
            }

        }

        return sum;
    }

    private static boolean validateNumber(int start, int end, int index) {

        if (index == input.size() - 1) { //don't want to go out of bounds
            if (checkSymbols(start, end, index) || checkSymbols(start, end, index - 1)) return true;
            return false;
        }
        //if (checkSymbol at current index) || checkSymbol at future index
        if (checkSymbols(start, end, index) || checkSymbols(start, end, index + 1)) return true;
        //if index > 0 )
        if (index> 0) {
            if (checkSymbols(start, end, index - 1)) return true;
        }

        return false;
    }

    private static boolean checkSymbols(int start, int end, int index) {
        //create string pattern of symbols
        String pattern = "[\\W&&[^.]]";

        //create a string called substring
        String substring;
        //extract substring using start and end and assign to substring
        substring = input.get(index).substring(start, end);
        //if (substr.matches(regex))
        Matcher mt = Pattern.compile(pattern).matcher(substring);
        while (mt.find()) return true;


        return false;
    }

}
