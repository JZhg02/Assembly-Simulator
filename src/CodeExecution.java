import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class CodeExecution {

    int problemCounter = 1;
    ArrayList<String> codeLine;
    ALU myALU = new ALU();
    Register t0 = new Register();
    Register t1 = new Register();
    Register t2 = new Register();
    Register t3 = new Register();

    public void executeCode() throws Exception {

        // Initialize the halt (HLT)
        boolean myHLT = false;


        // While we do not get to the last instruction,
        while(!myHLT){

            // Get the line of code at line problemCounter;
            codeLine = Memory.instructionsMap.get(problemCounter);
            System.out.println(Memory.instructionsMap.get(problemCounter));

            if(codeLine.get(0).equalsIgnoreCase("LDA")){
                if(codeLine.get(1).equals("t0")){
                    myALU.LDA(t0, codeLine.get(2));
                } else if (codeLine.get(1).equals("t1")){
                    myALU.LDA(t1, codeLine.get(2));
                } else if (codeLine.get(1).equals("t2")){
                    myALU.LDA(t2, codeLine.get(2));
                } else {
                    myALU.LDA(t3, codeLine.get(2));
                }
                ++problemCounter;
            }
            /*
            else if(codeLine.get(0).equalsIgnoreCase("STR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("PUSH")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("POP")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("AND")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("OR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("NOT")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("ADD")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("SUB")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("DIV")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("MUL")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("MOD")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("INC")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("DEC")){
                myALU.STR(codeLine.get(1));
                ++problemCounter;
            }

            // Instructions that needs jumps
            else if(codeLine.get(0).equalsIgnoreCase("BEQ")){
                // We could change the problemCounter here or make the function in ALU return a number directly
                // I think the latter is better just to have all "computations" done in ALU.
            }

            else if(codeLine.get(0).equalsIgnoreCase("BNE")){

            }

            else if(codeLine.get(0).equalsIgnoreCase("BBG")){

            }

            else if(codeLine.get(0).equalsIgnoreCase("BSM")){

            }*/

            else if(codeLine.get(0).equalsIgnoreCase("JMP")){
                myALU.JMP(codeLine.get(1) , problemCounter);
            }
            /*
            else if(codeLine.get(0).equalsIgnoreCase("SRL")){

            }

            else if(codeLine.get(0).equalsIgnoreCase("SSR")){

            }*/

            else if(codeLine.get(0).equalsIgnoreCase("HLT")){
                myHLT = true;
            }

            // If it is not one of those instructions, then it means we are facing a function (LABEL), or we reached
            // the end of a badly written code.
            // If facing a function, we just need to increment the PC, nothing to do, jumping to LABEL are taken care
            // of by the instructions that needs it.
            else {
                ++problemCounter;
            }

        }

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
