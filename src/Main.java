
public class Main {
    public static void main(String []args) throws Exception {

        System.out.println("Hello\n");
        FileParser myfile = new FileParser();
        myfile.getLines();
        System.out.println("The lines of data and instructions: "+myfile.lines);
        myfile.getDataLines();
        System.out.println("The lines of data: "+myfile.dataLines);
        myfile.getInstructionsLines();
        System.out.println("The lines of instructions: "+myfile.instructionsLines);

        Memory myMemory = new Memory();
        myfile.getData();
        System.out.println("Data in the map: "+Memory.dataMap);
        myfile.getInstructions();
        System.out.println("Instructions in the map: "+Memory.instructionsMap);
        System.out.println("Memory: "+Memory.memory);

        /*
        MyStack myStack = new MyStack();

        myStack.push(5);
        System.out.println("Stack: "+myStack);
        myStack.push(7);
        System.out.println("Stack: "+myStack);
        myStack.push(2);
        System.out.println("Stack: "+myStack);
        int register = myStack.pop();
        System.out.println("Stack after: "+myStack);
        System.out.println("Register: "+register);
        */

        ALU myALU = new ALU();
        Register t0 = new Register();
        Register t1 = new Register();
        Register t2 = new Register();
        Register t3 = new Register();

        System.out.println(myALU.int2binary(35));
        System.out.println("Test trying to add 10 to t0: "+ myALU.LDA(t0, "10"));
        System.out.println("Printing t0: " +t0);
        System.out.println("Printing dec value of t0: " +t0.getDecimalValue());

        CodeExecution myCode = new CodeExecution();
        myCode.executeCode();


        MyStack myStack = new MyStack();
        System.out.println("Stack: "+myStack);


        String valueName = "10";
        myALU.LDA(t0, valueName);
        System.out.println("Printing t0: " +t0);;
        String cont = "3";
        String var = "memoire";
        System.out.println(myALU.STR(var, cont));
        myALU.PUSH(String.valueOf(t0));
        System.out.println("Mystack: "+myStack);
        myALU.ADD(t0,valueName);
        System.out.println("Printing t0: " +t0);
        myALU.POP(t0);
        System.out.println("Stack: "+myStack);
        System.out.println("Printing t0: " +t0);
        myALU.AND(t0, valueName);
        System.out.println("Printing t0: " +t0);
        myALU.OR(t0, valueName);
        System.out.println("Printing t0: " +t0);
        myALU.NOT(t0);
        System.out.println("Printing t0: " +t0);
        myALU.SUB(t0, valueName);
        System.out.println("Printing t0: " +t0);
        myALU.MUL(t0, valueName);
        System.out.println("Printing t0: " +t0);
        myALU.DIV(t0, valueName);
        System.out.println("Printing t0: " +t0);
        myALU.MOD(t0, valueName);
    }
}
