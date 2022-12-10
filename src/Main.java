import java.net.SocketTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String []args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("\033[0;31m" +"Welcome to the Assembly Simulator by Zhang, Calarn and Cocatrix");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("This program implements an architecture simulator that implements an ISA of 20 instructions ");
        System.out.println("Its goal is to recreate a program able to read assembly file");
        System.out.println("--------------------------------------------------------------------------------------------"+"\033[0m");
        char choice = ' ';
        do {

            Memory memory = new Memory();
            System.out.println(Memory.memory);

            int fileName = 0;

            FileParser myfile = null;
            System.out.println("\033[1;34m"+"Enter the number of the file you want to run (between 1-10): "+"\033[0m");

            do {
                String Number;
                Number = sc.next();
                try {
                    fileName = Integer.parseInt(Number);

                    if (fileName < 1) {
                        System.out.println("You entered a negative number, please enter a number between 1 and 10");
                    } else if (fileName > 10) {
                        System.out.println("You entered a number greater than 10, please enter a number between 1 and 10");
                    } else {
                        System.out.println("You entered a valid number ! The program will now run the file n-" + fileName);
                        myfile = new FileParser(fileName);
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid file name");
                }
            } while (fileName < 1 || fileName > 10);


            myfile.getLines();
            myfile.getDataLines();
            myfile.getInstructionsLines();
            myfile.getData();
            myfile.getInstructions();
            /*
            Memory myMemory = new Memory();
            System.out.println("Data in the map: "+Memory.dataMap);
            System.out.println("Instructions in the map: "+Memory.instructionsMap);
            System.out.println("Memory: "+Memory.memory);*/

            CodeExecution myCode = new CodeExecution();
            myCode.executeCode();
            MyStack myStack = new MyStack();
            System.out.println(myStack);

            System.out.println("Do you want to simulate a new file? Say"+"\033[1;32m" +
                    "Y(es)"+ "\033[0m"+" or " + "\033[1;91m" + "N(o): \n" + "\033[0m");
            choice = sc.next().charAt(0);
            if(String.valueOf(choice).equalsIgnoreCase("y")){
                CodeExecution.problemCounter = 1;
                CodeExecution.programCounter = 1;
            }
        }
        while (choice == 'Y' || choice == 'y');
        System.out.println("Thank you for using our program, goodbye!");
    }
}
