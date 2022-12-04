public class Main {
    public static void main(String []args){

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
    }
}
