/*
 Name :  Tharana Sandul Fernando
 UOW  :   w2051566    ,    IIT  :  20230147

*/

package GraphPackage;

import MaxFlowCalcualation.MaxFlowCalculation;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    int size;

    private final List<Node>[] adjacencyList;




    public Graph(int size) {
        this.size = size;



        adjacencyList = (List<Node>[]) new List[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new ArrayList<>();

        }


    }
    


    public void addEdge(int source,int destination,int weight){

        if (source<0 || source>=size || destination<0 || destination>=size){
            throw new IllegalArgumentException("Vertex index out of bounds");
        }

        Node forward = new Node(destination, weight);
        Node reverse = new Node(source, 0);

        forward.reverse = reverse;
        reverse.reverse = forward;
        adjacencyList[source].add(forward);
        adjacencyList[destination].add(reverse);




    }


    public void maxFlow(int source, int destination){
        MaxFlowCalculation max = new MaxFlowCalculation();
        max.edmondsKarp(source,destination,size,adjacencyList);

    }











}
