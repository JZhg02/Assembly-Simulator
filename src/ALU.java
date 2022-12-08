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
            int index = Integer.parseInt(valueName);
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

    public void STR(String VariableName, String ValueName) throws Exception {
        if (isRegister(ValueName)) {
            ValueName = String.valueOf(new Register());
            Memory.dataMap.put(VariableName, Integer.valueOf(ValueName));
        } else {
            int index = Memory.dataMap.get(ValueName);
            Memory.dataMap.put(VariableName, index);
        }
    }

    public void PUSH(String ValueName) throws Exception {
        if (((isRegister(ValueName)) || (isVariable(ValueName))) || (ValueName.charAt(0) >= '0' && ValueName.charAt(0) <= '9')) {
            int index = Memory.dataMap.get(ValueName);
            MyStack.push(index);
        }
    }

    public void POP(Register register) throws Exception {
        int index = MyStack.pop();
        char[] binary = int2binary(Integer.parseInt(String.valueOf(index)));
        register.setRegister(binary);
    }



    public void AND(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            valueName = String.valueOf(new Register());
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) & Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else if(isVariable(valueName)) {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) & Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) & Integer.parseInt(valueName));
            registerName.setRegister(t);
        }
    }

    public void OR(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            valueName = String.valueOf(new Register());
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) | Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else if(isVariable(valueName)) {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) | Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) | Integer.parseInt(valueName));
            registerName.setRegister(t);
        }
    }

    public void NOT(Register registerName) throws Exception {
        char[] t = int2binary(~Memory.dataMap.get(String.valueOf(registerName)));
        registerName.setRegister(t);
    }

    public void ADD(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            valueName = String.valueOf(new Register());
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) + Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else if(isVariable(valueName)) {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) + Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) + Integer.parseInt(valueName));
            registerName.setRegister(t);
        }
    }

    public void SUB(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            valueName = String.valueOf(new Register());
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) - Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else if(isVariable(valueName)) {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) - Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) - Integer.parseInt(valueName));
            registerName.setRegister(t);
        }
    }


    public void DIV(Register registerName, String valueName) throws Exception {
        if(isRegister(valueName)) {
            valueName = String.valueOf(new Register());
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) / Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else if(isVariable(valueName)) {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) / Memory.dataMap.get(valueName));
            registerName.setRegister(t);
        } else {
            char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) / Integer.parseInt(valueName));
            registerName.setRegister(t);
        }
    }

   public void MUL(Register registerName, String valueName) throws Exception {
       if (isRegister(valueName)) {
           valueName = String.valueOf(new Register());
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) * Memory.dataMap.get(valueName));
           registerName.setRegister(t);
       } else if (isVariable(valueName)) {
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) * Memory.dataMap.get(valueName));
           registerName.setRegister(t);
       } else {
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) * Integer.parseInt(valueName));
           registerName.setRegister(t);
       }
   }

   public void MOD(Register registerName, String valueName) throws Exception {
       if (isRegister(valueName)) {
           valueName = String.valueOf(new Register());
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) % Memory.dataMap.get(valueName));
           registerName.setRegister(t);
       } else if (isVariable(valueName)) {
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) % Memory.dataMap.get(valueName));
           registerName.setRegister(t);
       } else {
           char[] t = int2binary(Memory.dataMap.get(String.valueOf(registerName)) % Integer.parseInt(valueName));
           registerName.setRegister(t);
       }
   }
   public void INC(Register RegisterName) throws Exception {
       char[] t = int2binary(Integer.parseInt(String.valueOf(RegisterName), 2) + 1);
       RegisterName.setRegister(t);
   }
   public void DEC(Register RegisterName) throws Exception {
       char[] t = int2binary(Integer.parseInt(String.valueOf(RegisterName), 2) - 1);
       RegisterName.setRegister(t);
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
