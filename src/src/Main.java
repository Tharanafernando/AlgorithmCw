/*
 Name :  Tharana Sandul Fernando
 UOW  :   w2051566    ,    IIT  :  20230147

*/


import FileReaderPackage.Passer;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Enter the path of the file");
            System.out.println("Example - 'benchmarkFiles/bridge_1.txt'");
            String filepath = scanner.nextLine();
            try{
                Passer pointer = new Passer();
                pointer.readFile(filepath);
                break;
            }
            catch(IOException e){
                System.out.println("Error reading file");
                System.out.println("Please enter a valid path");
                if (filepath.equalsIgnoreCase("E")){
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Bad file format");
                System.out.println("Please enter a valid path or Press 'E' to exit");
            }


            System.out.println("Want to run another file: Enter 'C' to continue OR enter 'E' to exit");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("E")) {
                continueLoop = false;
            }


        }

        scanner.close();




    }
}