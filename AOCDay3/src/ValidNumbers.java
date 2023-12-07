import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumbers {

    private static final ArrayList<String> input = new ArrayList<>();
    public void printTotalVaidNumbers() throws FileNotFoundException {

        int sum = 0;

        File file = new File("data\\input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
             input.add(scanner.nextLine());
        }
        scanner.close();

        for (int index = 0; index < input.size(); index ++) {

            sum += retrieveSum(index);
        }

        System.out.println(sum);
    }

    private static Integer retrieveSum(int index) {

        String pattern = "[0-9]+";
        int sum = 0;

        Matcher mt = Pattern.compile(pattern).matcher(input.get(index));

        while (mt.find()) {

            String number = mt.group();

            int start = (mt.start() != 0) ? mt.start() -1 : 0;
            int end = (mt.end() != input.size()) ? mt.end() + 1 : mt.end();

            if (validateNumber(start, end, index)) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }

    private static boolean validateNumber(int start, int end, int index) {

        if (index == input.size() - 1) { //don't want to go out of bounds
            return checkSymbols(start, end, index) || checkSymbols(start, end, index - 1);
        }

        if (checkSymbols(start, end, index) || checkSymbols(start, end, index + 1)) return true;

        if (index> 0) {
            return checkSymbols(start, end, index - 1);
        }
        return false;
    }

    private static boolean checkSymbols(int start, int end, int index) {

        String pattern = "[\\W&&[^.]]";
        String substring;
        substring = input.get(index).substring(start, end);
        Matcher mt = Pattern.compile(pattern).matcher(substring);

        return mt.find();
    }

}
