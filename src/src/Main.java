import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filepath = "benchmarkFiles/bridge_1.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if(parts.length == 3){
                    int node1 = Integer.parseInt(parts[0]);
                    int node2 = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    System.out.println(node1 + " " + node2 + " " + weight);
                }else if(parts.length == 1){
                    int numberOfNodes = Integer.parseInt(parts[0]);
                    System.out.println(numberOfNodes);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}