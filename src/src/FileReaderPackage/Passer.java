/*
 Name :  Tharana Sandul Fernando
 UOW  :   w2051566    ,    IIT  :  20230147

*/

package FileReaderPackage;

import GraphPackage.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Passer {


    public void readFile(String filepath) throws IOException {

        Graph graph = null;

        int numberOfNodes = 0;

        ArrayList<Integer> nodes = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;


            while ((line = br.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                if(parts.length == 3){
                    int node1 = Integer.parseInt(parts[0]);
                    int node2 = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    nodes.add(node1);
                    nodes.add(node2);




                    graph.addEdge(node1,node2,weight);



                }else if(parts.length == 1){
                    numberOfNodes = Integer.parseInt(parts[0]);

                    graph = new Graph(numberOfNodes);
                }




            }
            if(graph != null){

                int destination = numberOfNodes-1;

                graph.maxFlow(0,destination);

                System.out.println();


            }


        } catch (IOException e) {
            throw new IOException("File not found");
        }

    }

}
