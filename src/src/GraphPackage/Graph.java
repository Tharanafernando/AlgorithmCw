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







//    public int edmondsKarp(int source, int destination){
//
//        int maxFlow = 0;
//        int[] parents = new int[size];
//        Node[] parentEdge = new Node[size];
//
//        while (true){
//            Arrays.fill(parents, -1);
//            Queue<Integer> queue = new ArrayDeque<>();
//            parents[source] = source;
//            queue.add(source);
//
//
//            while (!queue.isEmpty() && parents[destination] == -1){
//                int u = queue.poll();
//                for (Node node : adjacencyList[u]){
//                    int v = node.destination;
//                    if (parents[v] == -1 && node.residualCapacity()>0){
//                        parents[v] = u;
//                        parentEdge[v] = node;
//                        queue.add(v);
//                    }
//                }
//
//            }
//
//            if (parents[destination] == -1){
//                break;
//            }
//
//            // find bottleneck
//            int bottleneck = Integer.MAX_VALUE;
//            for (int v = destination; v != source; v = parents[v]){
//                bottleneck = Math.min(bottleneck, parentEdge[v].residualCapacity());
//            }
//
//            for (int v = destination; v != source; v = parents[v]){
//                parentEdge[v].augment(bottleneck);
//            }
//
//            maxFlow += bottleneck;
//
//
//            List<Integer> path = new ArrayList<>();
//            for (int v = destination; v != source; v = parents[v]){
//                path.add(v);
//            }
//            path.add(source);
//            Collections.reverse(path);
//            System.out.printf("Augmented %d units via %s%n",
//                    bottleneck, path);
//
//
//
//        }
//        System.out.println("Max flow = "+maxFlow);
//        return maxFlow;
//    }



}
