import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class CodeExecution {

    static int problemCounter = 1;
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
            System.out.println("PC: "+ problemCounter);

            // Done
            if(codeLine.get(0).equalsIgnoreCase("LDA")){
                myALU.LDA(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            /*
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
                myALU.POP(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("AND")){
                myALU.AND(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("OR")){
                myALU.OR(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("NOT")){
                myALU.NOT(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("ADD")){
                myALU.ADD(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("SUB")){
                myALU.SUB(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DIV")){
                myALU.DIV(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MUL")){
                myALU.MUL(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MOD")){
                myALU.MOD(checkRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("INC")){
                myALU.INC(checkRegister(codeLine.get(1)));
                ++problemCounter;
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DEC")){
                myALU.DEC(checkRegister(codeLine.get(1)));
                ++problemCounter;
            }

            // To be fixed
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

            /*
            else if(codeLine.get(0).equalsIgnoreCase("JMP")){
                myALU.JMP(codeLine.get(1));
                System.out.println(problemCounter);
            }*/
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

    public Register checkRegister(String registerName){
        if(registerName.equals("t0")){
            return this.t0;
        } else if (registerName.equals("t1")){
            return this.t1;
        } else if (registerName.equals("t2")){
            return this.t2;
        } else {
            return this.t3;
        }
    }

}
