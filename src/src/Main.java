import FileReaderPackage.Pointer;
import GraphPackage.Graph;
import GraphPackage.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file");
        System.out.println("Example - 'benchmarkFiles/bridge_15.txt'");
        String filepath = scanner.nextLine();
        Pointer pointer = new Pointer();
        pointer.readFile(filepath);


    }
}