import java.util.ArrayList;
import java.util.Map;

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
        if (s.equals("t0") || s.equals("t1") || s.equals("t2") || s.equals("t3")) {
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
/*
    // char[] c not used
    public void STR(String VariableName, String ValueName) throws Exception {
        if (isRegister(ValueName)) {
            int index = Integer.parseInt(ValueName);
            char[] c = int2char(index);
            Memory.dataMap.put(VariableName, index);
        } else if (isConstant(ValueName)) {
            int index = Integer.parseInt(ValueName);
            char[] c = int2char(index);
            Memory.dataMap.put(VariableName, index);
        }
    }

    public void PUSH(String ValueName) throws Exception {
        if (isRegister(ValueName)) {
           MyStack.push(Integer.parseInt(ValueName));
        } else if (isConstant(ValueName)) {
            MyStack.push(Integer.parseInt(ValueName));
        } else if (isVariable(ValueName)) {
            MyStack.push(Memory.dataMap.get(ValueName));
        }
    }

    public void POP(Register register) throws Exception {
        char[] t = int2char(Memory.dataMap.get("sp"));
        Memory.dataMap.put("sp", Memory.dataMap.get("sp") + 1);
        //t0.setRegisters(String.valueOf(register), t);
    }

    public void AND(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) & Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) & Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) & Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void OR(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) | Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) | Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) | Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void NOT(Register RegisterName) throws Exception {
        char[] t = int2char(~Integer.parseInt(String.valueOf(RegisterName), 2));
        RegisterName.setRegisters(String.valueOf(RegisterName), t);
    }

    public void ADD(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) + Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) + Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) + Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void SUB(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) - Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) - Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) - Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void DIV(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) / Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) / Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) / Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void MUL(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) * Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) * Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) * Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void MOD(Register RegisterName, String ValueName) throws Exception {
        if(isRegister(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) % Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isConstant(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) % Integer.parseInt(ValueName, 2));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        } else if (isVariable(ValueName)) {
            char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) % Memory.dataMap.get(ValueName));
            RegisterName.setRegisters(String.valueOf(RegisterName), t);
        }
    }

    public void INC(Register RegisterName) throws Exception {
        char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) + 1);
        RegisterName.setRegisters(String.valueOf(RegisterName), t);
    }
    public void DEC(Register RegisterName) throws Exception {
        char[] t = int2char(Integer.parseInt(String.valueOf(RegisterName), 2) - 1);
        RegisterName.setRegisters(String.valueOf(RegisterName), t);
    }


    public void BEQ(Register RegisterName, String ValueName, String LABEL) throws Exception {
        if(isRegister(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) == Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isConstant(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) == Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isVariable(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) == Memory.dataMap.get(ValueName)) {
                JMP(LABEL);
            }
        }
    }

    public void BNE(Register RegisterName, String ValueName, String LABEL) throws Exception {
        if(isRegister(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) != Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isConstant(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) != Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isVariable(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) != Memory.dataMap.get(ValueName)) {
                JMP(LABEL);
            }
        }
    }

    public void BBG(Register RegisterName, String ValueName, String LABEL) throws Exception {
        if(isRegister(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) > Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isConstant(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) > Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isVariable(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) > Memory.dataMap.get(ValueName)) {
                JMP(LABEL);
            }
        }
    }

    public void BSM(Register RegisterName, String ValueName, String LABEL) throws Exception {
        if(isRegister(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) < Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isConstant(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) < Integer.parseInt(ValueName, 2)) {
                JMP(LABEL);
            }
        } else if (isVariable(ValueName)) {
            if(Integer.parseInt(String.valueOf(RegisterName), 2) < Memory.dataMap.get(ValueName)) {
                JMP(LABEL);
            }
        }
    }*/

    public void JMP(String label, int problemCounter) throws Exception {
        for(Map.Entry<Integer, ArrayList<String>> set : Memory.instructionsMap.entrySet()){
            if(set.getValue().equals(label)){
                problemCounter = set.getKey();
                break;
            }
        }
    }



}
