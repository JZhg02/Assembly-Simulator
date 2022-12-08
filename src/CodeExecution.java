import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class CodeExecution {

    static int problemCounter = 1;
    ArrayList<String> codeLine;
    ALU myALU = new ALU();
    static Register t0 = new Register();
    static Register t1 = new Register();
    static Register t2 = new Register();
    static Register t3 = new Register();

    public void executeCode() throws Exception {

        // Initialize the halt (HLT)
        boolean myHLT = false;


        // While we do not get to the last instruction,
        while(!myHLT){

            // Get the line of code at line problemCounter;
            codeLine = Memory.instructionsMap.get(problemCounter);
            System.out.println(Memory.instructionsMap.get(problemCounter));
            System.out.println("PC: "+ problemCounter);

            // Done
            if(codeLine.get(0).equalsIgnoreCase("LDA")){
                myALU.LDA(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }

            // Done
            else if(codeLine.get(0).equalsIgnoreCase("STR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
            }

            // To be fixed
            else if(codeLine.get(0).equalsIgnoreCase("PUSH")){
                myALU.PUSH(codeLine.get(1));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("POP")){
                myALU.POP(determineRegister(codeLine.get(1)));
                ++problemCounter;
            }

            // Done
            else if(codeLine.get(0).equalsIgnoreCase("AND")){
                myALU.AND(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("OR")){
                myALU.OR(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("NOT")){
                myALU.NOT(determineRegister(codeLine.get(1)));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("ADD")){
                myALU.ADD(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("SUB")){
                myALU.SUB(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DIV")){
                myALU.DIV(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MUL")){
                myALU.MUL(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MOD")){
                myALU.MOD(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("INC")){
                myALU.INC(determineRegister(codeLine.get(1)));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DEC")){
                myALU.DEC(determineRegister(codeLine.get(1)));
                ++problemCounter;
            }

            // To be fixed
            // Instructions that needs jumps
            else if(codeLine.get(0).equalsIgnoreCase("BEQ")){
                myALU.BEQ(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("BNE")){
                myALU.BNE(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("BBG")){
                myALU.BBG(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("BSM")){
                myALU.BSM(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
            }

            else if(codeLine.get(0).equalsIgnoreCase("JMP")){
                myALU.JMP(codeLine.get(1));
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


    public static Register determineRegister(String registerName){
        if(registerName.equalsIgnoreCase("t0")){
            return t0;
        } else if (registerName.equalsIgnoreCase("t1")){
            return t1;
        } else if (registerName.equalsIgnoreCase("t2")){
            return t2;
        } else {
            return t3;
        }
    }

}
