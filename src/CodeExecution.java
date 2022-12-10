import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CodeExecution {

    static int problemCounter = 1;
    static int programCounter = 1;
    ArrayList<String> codeLine;
    ALU myALU = new ALU();
    static Register t0 = new Register();
    static Register t1 = new Register();
    static Register t2 = new Register();
    static Register t3 = new Register();

    boolean stepByStep = false;

    public void executeCode() throws Exception {

        // Initialize the halt (HLT)
        boolean myHLT = false;

        // While we do not get to the last instruction,
        while(!myHLT){

            // Get the line of code at line problemCounter;
            codeLine = Memory.instructionsMap.get(problemCounter);
            System.out.println("PC: "+ programCounter+" | Code Line: "+problemCounter+" | "+Memory.instructionsMap.get(problemCounter));

            // Done
            if(codeLine.get(0).equalsIgnoreCase("LDA")){
                myALU.LDA(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            // Done
            else if(codeLine.get(0).equalsIgnoreCase("STR")){
                myALU.STR(codeLine.get(1), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            // To be fixed
            else if(codeLine.get(0).equalsIgnoreCase("PUSH")){
                myALU.PUSH(codeLine.get(1));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("POP")){
                myALU.POP(determineRegister(codeLine.get(1)));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            // Done
            else if(codeLine.get(0).equalsIgnoreCase("AND")){
                myALU.AND(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("OR")){
                myALU.OR(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("NOT")){
                myALU.NOT(determineRegister(codeLine.get(1)));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("ADD")){
                myALU.ADD(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("SUB")){
                myALU.SUB(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DIV")){
                myALU.DIV(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MUL")){
                myALU.MUL(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("MOD")){
                myALU.MOD(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("INC")){
                myALU.INC(determineRegister(codeLine.get(1)));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
            // Done
            else if(codeLine.get(0).equalsIgnoreCase("DEC")){
                myALU.DEC(determineRegister(codeLine.get(1)));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("BEQ")){
                myALU.BEQ(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("BNE")){
                myALU.BNE(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("BBG")){
                myALU.BBG(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("BSM")){
                myALU.BSM(codeLine.get(1), codeLine.get(2), codeLine.get(3));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("JMP")){
                myALU.JMP(codeLine.get(1));
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("SRL")){
                myALU.SRL(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("SRR")){
                myALU.SRR(determineRegister(codeLine.get(1)), codeLine.get(2));
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }

            else if(codeLine.get(0).equalsIgnoreCase("HLT")){
                myHLT = true;
            }

            // If it is not one of those instructions, then it means we are facing a function (LABEL), or we reached
            // the end of a badly written code.
            // If facing a function, we just need to increment the PC, nothing to do, jumping to LABEL are taken care
            // of by the instructions that needs it.
            else {
                ++problemCounter;
                ++programCounter;
                if(stepByStep){
                    enterInput();
                }
            }
        }
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

    private void enterInput() {
        System.out.println("Press any keys and enter to continue");
        try {
            char input = (char) System.in.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
