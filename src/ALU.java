import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class ALU {
    Register t0 = new Register();
    Register t1 = new Register();
    Register t2 = new Register();
    Register t3 = new Register();
    int maxLength = 32;

    public char[] int2char(int b) throws Exception {


        // Convert int bb to 0,1 char[]
        char[] binary = (Integer.toString(b, 2)).toCharArray();


        // Overflow condition
        if (binary.length > maxLength)
            throw new Exception("Overflow");

        return binary;
    }

    public int char2int(char[] c) {
        return Integer.parseInt(new String(c), 2);
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

    public boolean isConstant(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            return true;
        }
        return false;
    }


    public Register LDA(Register RegisterName, String ValueName) throws Exception {
        if (isRegister(ValueName)) {
            int index = Integer.parseInt(ValueName);
            char[] c = int2char(index);
            RegisterName.setRegisters(ValueName, c);
        } else if (isVariable(ValueName)) {
            int index = Memory.dataMap.get(ValueName);
            char[] c = int2char(index);
            RegisterName.setRegisters(ValueName, c);
        } else if (isConstant(ValueName)) {
            int index = Integer.parseInt(ValueName);
            char[] c = int2char(index);
            RegisterName.setRegisters(ValueName, c);
        }
        return RegisterName;
    }


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
        t0.setRegisters(String.valueOf(register), t);
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
    }

    public void JMP(String label) throws Exception {
        int i = 0;
        for(Object s : Memory.codeMap.keySet()) {
            if(s.equals(label)) {
                break;
            }
            i++;
        }
        Memory.codeMap.get(label).setIndex(i);
    }



}
