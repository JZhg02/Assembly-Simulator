public class Register {
    int[] array;

    String registers = "00000000000000000000000000000000";

    public Register(){
        array = new int[32];
        for(int i = 0; i < 32; i++){
            array[i] = 0;
        }
    }

    public Register(String registers) {
        array = new int[32];
        for (int i = 0; i < 32; i++) {
            array[i] = 0;
        }
    }
    public void setRegisters(String register, char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1') {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }
    public String getBinary(int index) {
        return Integer.toBinaryString(array[index]);
    }

    public String getHex(int index) {
        return Integer.toHexString(array[index]);
    }

}