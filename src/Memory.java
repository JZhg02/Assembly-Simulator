import java.util.ArrayList;
import java.util.HashMap;

public class Memory {

    // Memory (could be infinite as the professor said so...)
    static ArrayList<HashMap> memory = new ArrayList<>(2);
    // 1st Hashmap = data
    static HashMap<String, Integer> dataMap = new HashMap<>();
    // 2nd Hashmap = instructions/code
    static HashMap<Integer, ArrayList<String>> instructionsMap = new HashMap<>();

    Memory(){
        memory.add(dataMap);
        memory.add(instructionsMap);
    }

}
