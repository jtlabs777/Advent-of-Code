import java.util.HashMap;
import java.util.Map;

public class GameValidator {

    public boolean isPossible(String set) {
        //create a hash table that holds the key/value paris red 12, green 13, 14 blue
        Map<String, Integer> requirements = new HashMap<>()
        {{
           put("red", 12);
           put("green", 13);
           put("blue", 14);
        }};

        //split string by "," and store in array called blocks
        String[] blocks = set.split(", ");
        //loop through each item in blocks
        for (String block : blocks) {
            //split each block and store in array called block and store in array called blockPair(localLevel)
            String[] blockPair = block.trim().split(" ");
            // convert blockPair[0] to integer and store in integer called blockNumber (localVar)
            int blockNumber = Integer.valueOf(blockPair[0]);
            //take blockPair[1] and pass it into hash requirements to get int value, compare value to blockNumber
            if (blockNumber > requirements.get(blockPair[1])) {
                return false;
            } else continue;
        }


       //return true
        return true;
    }
}
