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
            Passer pointer = new Passer();
            pointer.readFile(filepath);

            System.out.println("Want to run another file: Enter 'C' to continue OR enter 'E' to exit");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("E")) {
                continueLoop = false;
            }


        }



    }
}