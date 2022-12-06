import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class CodeExecution {

    int problemCounter = 1;
    ArrayList<String> codeLine;
    ALU myALU = new ALU();

    public void executeCode() throws Exception {

        // Initialize the halt (HLT)
        boolean myHLT = false;

        /*
        // While we do not get to the last instruction,
        while(!myHLT){

            // Get the line of code at line problemCounter;
            codeLine = Memory.instructionsMap.get(problemCounter);

            if(codeLine.get(0).equalsIgnoreCase("LDA")){
                myALU.LDA(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("STR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("PUSH")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("POP")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("AND")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("OR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("NOT")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("ADD")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("SUB")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("DIV")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("MUL")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("MOD")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("INC")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            if(codeLine.get(0).equalsIgnoreCase("DEC")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            // Instructions that needs jumps
            if(codeLine.get(0).equalsIgnoreCase("BEQ")){
                // We could change the problemCounter here or make the function in ALU return a number directly
                // I think the latter is better just to have all "computations" done in ALU.
            }

            if(codeLine.get(0).equalsIgnoreCase("BNE")){

            }

            if(codeLine.get(0).equalsIgnoreCase("BBG")){

            }

            if(codeLine.get(0).equalsIgnoreCase("BSM")){

            }

            if(codeLine.get(0).equalsIgnoreCase("JMP")){

            }

            if(codeLine.get(0).equalsIgnoreCase("SRL")){

            }

            if(codeLine.get(0).equalsIgnoreCase("SSR")){

            }

            if(codeLine.get(0).equalsIgnoreCase("HLT")){
                myHLT = true;
            }

            // If it is not one of those instructions, then it means we are facing a function (LABEL), or we reached
            // the end of a badly written code.
            // If facing a function, we just need to increment the PC, nothing to do, jumping to LABEL are taken care
            // of by the instructions that needs it.
            ++problemCounter;

        }*/

        /*
        // This was for testing, might be useful later?
        for(HashMap.Entry<Integer, ArrayList<String>> entry : Memory.instructionsMap.entrySet()){
            problemCounter = entry.getKey();
            codeLine = entry.getValue();
            System.out.println("This is problem counter "+problemCounter);
            System.out.println("This is code line: "+codeLine);
        }*/
    }

}
