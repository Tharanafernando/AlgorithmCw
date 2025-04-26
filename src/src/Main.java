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
        Graph graph = null;
        String filepath = "benchmarkFiles/bridge_15.txt";
        //String filepath = "benchmarkFiles/ladder_1.txt";
        int numberOfNodes = 0;

        ArrayList<Integer>nodes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;


            while ((line = br.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                if(parts.length == 3){
                    int node1 = Integer.parseInt(parts[0]);
                    int node2 = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    nodes.add(node1);
                    nodes.add(node2);



                    graph.addVertex(node1);
                    graph.addVertex(node2);
                    graph.addEdge(node1,node2,weight);



                }else if(parts.length == 1){
                    numberOfNodes = Integer.parseInt(parts[0]);

                    graph = new Graph(numberOfNodes);
                }




            }
            if(graph != null){
                System.out.println("DFS path starting from node 0: ");

                int maxValue = Collections.max(nodes);
                int minValue = Collections.min(nodes);
                int destination = numberOfNodes-1;
                System.out.println(maxValue);
                System.out.println(minValue);
                //graph.fordFulkerson(0,destination);
                graph.edmondsKarp(0,destination);

                System.out.println();
               // graph.printGraph();

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}