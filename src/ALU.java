import java.util.ArrayList;

public class ALU {
    public Register t0;
    public Register t1;
    public Register t2;
    public  Register t3;
    public int maxLength;

    ALU() {
        this.t0 = new Register("t0");
        this.t1 = new Register("t1");
        this.t2 = new Register("t2");
        this.t3 = new Register("t3");
        this.maxLength = 32;
    }


    public char[] int2char(int b) throws Exception {

        // Convert int bb to 0,1 char[]
        char[] binary = (Integer.toString(b, 2)).toCharArray();

        // Overflow condition
        if (binary.length > maxLength)
            throw new Exception("Overflow");

        // Initialize char[] c
        char[] c = new char[maxLength];
        for (int i = 0; i < c.length; i++) {
            c[i] = '0';
        }

        // Copy the value of barr to char[] c
        for (int i = binary.length - 1; i >= 0; i--) {
            c[i + c.length - binary.length] = binary[i];
        }

        return c;
    }

    public int char2int(char[] c) {
        return Integer.parseInt(new String(c), 2);
    }



    public void LDA(String register, String register2) throws Exception {
        int index = Integer.parseInt(register2);
        char[] c = int2char(index);
        t0.setRegisters(register, c);
    }


    public void LDAv2(String register, int constante) throws Exception {
        char[] t = int2char(constante);
        t0.setRegisters(register, t);
    }
    public void LDAv3(String register, String var) throws Exception {
        char[] t = int2char(Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }



    public void STR(String register, int constante) throws Exception {
        char[] t = int2char(constante);
        Memory.dataMap.put(register, char2int(t));
    }
    public void PUSH(String register) throws Exception {
        char[] t = int2char(Memory.dataMap.get(register));
        Memory.dataMap.put("sp", Memory.dataMap.get("sp") - 1);
        Memory.dataMap.put("sp", char2int(t));
    }
    public void PUSHv2(int constante) throws Exception {
        char[] t = int2char(constante);
        Memory.dataMap.put("sp", Memory.dataMap.get("sp") - 1);
        Memory.dataMap.put("sp", char2int(t));
    }


    public void PUSHv3(String var) throws Exception {
        char[] t = int2char(Memory.dataMap.get(var));
        Memory.dataMap.put("sp", Memory.dataMap.get("sp") - 1);
        Memory.dataMap.put("sp", char2int(t));
    }
    public void POP(String register) throws Exception {
        char[] t = int2char(Memory.dataMap.get("sp"));
        Memory.dataMap.put("sp", Memory.dataMap.get("sp") + 1);
        t0.setRegisters(register, t);
    }
    public void AND(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) & Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }



    public void ANDv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) & constante);
        t0.setRegisters(register, t);
    }
    public void ANDv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) & Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }
    public void OR(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) | Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }



    public void ORv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) | constante);
        t0.setRegisters(register, t);
    }
    public void ORv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) | Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }
    public void NOT(String register) throws Exception {
        char[] t = int2char(~Integer.parseInt(register, 2));
        t0.setRegisters(register, t);
    }



    public void ADD(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) + Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }
    public void ADDv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) + constante);
        t0.setRegisters(register, t);
    }
    public void ADDv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) + Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }


    public void SUB(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) - Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }
    public void SUBv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) - constante);
        t0.setRegisters(register, t);
    }
    public void SUBv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) - Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }


    public void DIV(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) / Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }
    public void DIVv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) / constante);
        t0.setRegisters(register, t);
    }
    public void DIVv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) / Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }


    public void MUL(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) * Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }
    public void MULv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) * constante);
        t0.setRegisters(register, t);
    }
    public void MULv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) * Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }


    public void MOD(String register, String register2) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) % Integer.parseInt(register2, 2));
        t0.setRegisters(register, t);
    }
    public void MODv2(String register, int constante) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) % constante);
        t0.setRegisters(register, t);
    }
    public void MODv3(String register, String var) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) % Memory.dataMap.get(var));
        t0.setRegisters(register, t);
    }

    public void INC(String register) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) + 1);
        t0.setRegisters(register, t);
    }

    public void DEC(String register) throws Exception {
        char[] t = int2char(Integer.parseInt(register, 2) - 1);
        t0.setRegisters(register, t);
    }}
