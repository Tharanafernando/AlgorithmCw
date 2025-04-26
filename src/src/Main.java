import FileReaderPackage.Pointer;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Enter the path of the file");
            System.out.println("Example - 'benchmarkFiles/bridge_15.txt'");
            String filepath = scanner.nextLine();
            Pointer pointer = new Pointer();
            pointer.readFile(filepath);

            System.out.println("Want to run another file: Enter 'C' to continue OR enter 'E' to exit");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("E")) {
                continueLoop = false;
            }

        }



    }
}