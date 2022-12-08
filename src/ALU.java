import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ALU {


    public char[] int2binary(int decimal) throws Exception {

        // Convert int bb to 0,1 char[]
        char[] binary = (Integer.toString(decimal, 2)).toCharArray();

        // Overflow condition, 32 is max legnth
        if (binary.length > 32)
            throw new Exception("Overflow");

        return binary;
    }

    public int binary2int(char[] binary) {
        return Integer.parseInt(new String(binary), 2);
    }

    public boolean isRegister(String s) {
        if (s.equalsIgnoreCase("t0") || s.equalsIgnoreCase("t1") || s.equalsIgnoreCase("t2") || s.equalsIgnoreCase("t3")) {
            return true;
        }
        return false;
    }

    public boolean isVariable(String s) {
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z' || s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            return true;
        }
        return false;
    }

    public Register LDA(Register registerName, String valueName) throws Exception {
        if (isRegister(valueName)) {
            int index = CodeExecution.determineRegister(valueName).getDecimalValue();
            char[] binary = int2binary(index);
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            int index = Memory.dataMap.get(valueName);
            char[] binary = int2binary(index);
            registerName.setRegister(binary);
        } else {
            int index = Integer.parseInt(valueName);
            char[] binary = int2binary(index);
            registerName.setRegister(binary);
        }
        return registerName;
    }

    public void STR(String variableName, String valueName){
        if (isRegister(valueName)) {
            int integerValue = CodeExecution.determineRegister(valueName).getDecimalValue();
            Memory.dataMap.put(variableName, integerValue);
        } else {
            Memory.dataMap.put(variableName, Integer.parseInt(valueName));
        }
    }

    public void PUSH(String valueName) throws Exception {
        if(isRegister(valueName)){
            int integerValue = CodeExecution.determineRegister(valueName).getDecimalValue();
            MyStack.push(integerValue);
        } else if(isVariable(valueName)) {
            int integerValue = Memory.dataMap.get(valueName);
            MyStack.push(integerValue);
        } else {
            int integerValue = Integer.parseInt(valueName);
            MyStack.push(integerValue);
        }
    }

    public void POP(Register register) throws Exception {
        int integerValue = MyStack.pop();
        char[] binary = int2binary(integerValue);
        register.setRegister(binary);
    }



    public void AND(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() & registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) & registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) & registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void OR(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() | registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) | registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) | registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void NOT(Register registerName) throws Exception {
        char [] binary = int2binary(~registerName.getDecimalValue());
        registerName.setRegister(binary);

    }

    public void ADD(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() + registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) + registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) + registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }


    public void SUB(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() - registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) - registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) - registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void DIV(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() / registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) / registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) / registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void MUL(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() * registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) * registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) * registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void MOD(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() % registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) % registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) % registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void SRL(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() >> registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) >> registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) >> registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }

    public void SRR(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            char [] binary = int2binary(CodeExecution.determineRegister(valueName).getDecimalValue() << registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else if (isVariable(valueName)) {
            char [] binary = int2binary(Memory.dataMap.get(valueName) << registerName.getDecimalValue());
            registerName.setRegister(binary);
        } else {
            char [] binary = int2binary(Integer.parseInt(valueName) << registerName.getDecimalValue());
            registerName.setRegister(binary);
        }
    }


   public void INC(Register registerName) throws Exception {
       char [] binary = int2binary(registerName.getDecimalValue() + 1);
       registerName.setRegister(binary);
   }

   public void DEC (Register registerName) throws Exception {
        char [] binary = int2binary(registerName.getDecimalValue() - 1);
        registerName.setRegister(binary);
   }



   public void BEQ(String firstParam, String secondParam, String LABEL) {
       int firstValue;
       int secondValue;
       // If 1st param is a register
       if (isRegister(firstParam)) {
           firstValue = CodeExecution.determineRegister(firstParam).getDecimalValue();
           // If 2nd param is also a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // If 2nd param is a variable
           else if (isVariable(secondParam)) {
               secondValue = Memory.dataMap.get(secondParam);
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // Then this means that 2nd param is for sure a constant
           else if (firstValue == Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }// If 1st param is a variable
       else if (isVariable(firstParam)) {
           firstValue = Memory.dataMap.get(firstParam);
           // If 2nd param is a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // If 2nd param is also a variable
           else if (isVariable(secondParam)) {
               secondValue = Memory.dataMap.get(secondParam);
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is for sure a constant
           else if (firstValue == Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }
       // 1st param is a constant
       else {
           firstValue = Integer.parseInt(firstParam);
           // 2nd param is a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is a variable
           else if (isVariable(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue == secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is forcibly also a constant
           else if (firstValue == Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }
   }

   public void BNE(String firstParam, String secondParam, String LABEL) {
       int firstValue;
       int secondValue;
       // If 1st param is a register
       if (isRegister(firstParam)) {
           firstValue = CodeExecution.determineRegister(firstParam).getDecimalValue();
           // If 2nd param is also a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // If 2nd param is a variable
           else if (isVariable(secondParam)) {
               secondValue = Memory.dataMap.get(secondParam);
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // Then this means that 2nd param is for sure a constant
           else if (firstValue != Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }
       // If 1st param is a variable
       else if (isVariable(firstParam)) {
           firstValue = Memory.dataMap.get(firstParam);
           // If 2nd param is a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // If 2nd param is also a variable
           else if (isVariable(secondParam)) {
               secondValue = Memory.dataMap.get(secondParam);
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is for sure a constant
           else if (firstValue != Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }
       // 1st param is a constant
       else {
           firstValue = Integer.parseInt(firstParam);
           // 2nd param is a register
           if (isRegister(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is a variable
           else if (isVariable(secondParam)) {
               secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
               if (firstValue != secondValue) {
                   JMP(LABEL);
               }
           }
           // 2nd param is forcibly also a constant
           else if (firstValue != Integer.parseInt(secondParam)) {
               JMP(LABEL);
           }
       }
   }

    public void BBG(String firstParam, String secondParam, String LABEL){
        int firstValue;
        int secondValue;
        // If 1st param is a register
        if(isRegister(firstParam)) {
            firstValue = CodeExecution.determineRegister(firstParam).getDecimalValue();
            // If 2nd param is also a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // If 2nd param is a variable
            else if (isVariable(secondParam)){
                secondValue = Memory.dataMap.get(secondParam);
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // Then this means that 2nd param is for sure a constant
            else if (firstValue > Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
        // If 1st param is a variable
        else if (isVariable(firstParam)) {
            firstValue = Memory.dataMap.get(firstParam);
            // If 2nd param is a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // If 2nd param is also a variable
            else if (isVariable(secondParam)){
                secondValue = Memory.dataMap.get(secondParam);
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is for sure a constant
            else if (firstValue > Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
        // 1st param is a constant
        else {
            firstValue = Integer.parseInt(firstParam);
            // 2nd param is a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is a variable
            else if(isVariable(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue > secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is forcibly also a constant
            else if(firstValue > Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
    }

    public void BSM(String firstParam, String secondParam, String LABEL){
        int firstValue;
        int secondValue;
        // If 1st param is a register
        if(isRegister(firstParam)) {
            firstValue = CodeExecution.determineRegister(firstParam).getDecimalValue();
            // If 2nd param is also a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // If 2nd param is a variable
            else if (isVariable(secondParam)){
                secondValue = Memory.dataMap.get(secondParam);
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // Then this means that 2nd param is for sure a constant
            else if (firstValue < Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
        // If 1st param is a variable
        else if (isVariable(firstParam)) {
            firstValue = Memory.dataMap.get(firstParam);
            // If 2nd param is a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // If 2nd param is also a variable
            else if (isVariable(secondParam)){
                secondValue = Memory.dataMap.get(secondParam);
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is for sure a constant
            else if (firstValue < Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
        // 1st param is a constant
        else {
            firstValue = Integer.parseInt(firstParam);
            // 2nd param is a register
            if(isRegister(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is a variable
            else if(isVariable(secondParam)){
                secondValue = CodeExecution.determineRegister(secondParam).getDecimalValue();
                if(firstValue < secondValue){
                    JMP(LABEL);
                }
            }
            // 2nd param is forcibly also a constant
            else if(firstValue < Integer.parseInt(secondParam)){
                JMP(LABEL);
            }
        }
    }

    public void JMP(String label){
        for(Map.Entry<Integer, ArrayList<String>> set : Memory.instructionsMap.entrySet()){
            if(set.getValue().get(0).equals(label)){
                CodeExecution.problemCounter = set.getKey();
                break;
            }
        }
    }

}
