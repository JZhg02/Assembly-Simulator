public class Register {

    char[] value = new char[32];

    public Register(){
        for(int i=0; i<32; i++){
            this.value[i] = '0';
        }
    }

    public void setRegister(char[] binaryNumber) {
        for(int i=binaryNumber.length-1; i>=0; i--){
            if(binaryNumber[binaryNumber.length-1-i] == '1'){
                this.value[31-i] = '1';
            } else {
                this.value[31-i] = '0';
            }
        }
    }

    public int getDecimalValue(){
        return(Integer.parseInt(String.valueOf(this.value), 2));
    }

    public String getBinary(int index) {
        return Integer.toBinaryString(this.value[index]);
    }

    public String getHex(int index) {
        return Integer.toHexString(this.value[index]);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("");
        for(int i=0; i<this.value.length; i++){
            str.append(this.value[i]);
        }
        return str.toString();
    }

}