import GraphPackage.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Graph graph = null;
        String filepath = "benchmarkFiles/bridge_1.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            int[] vertexArray;
            while ((line = br.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                if(parts.length == 3){
                    int node1 = Integer.parseInt(parts[0]);
                    int node2 = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);

//                    System.out.println(node1);
                    graph.addVertex(node1);
                    graph.addVertex(node2);
                    graph.addEdge(node1,node2,weight);


//                    System.out.println(node1 + " " + node2 + " " + weight);
                }else if(parts.length == 1){
                    int numberOfNodes = Integer.parseInt(parts[0]);

                    graph = new Graph(numberOfNodes);
                }




            }
            if(graph != null){
                System.out.println("DFS path starting from node 0: ");
                graph.dfs(0);
                System.out.println();

            }

            graph.printGraph();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}