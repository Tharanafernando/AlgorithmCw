package MaxFlowCalcualation;

import GraphPackage.Node;

import java.util.*;

public class MaxFlowCalculation {

    public int edmondsKarp(int source, int destination,int size,List<Node>[] adjacencyList){

        int maxFlow = 0;
        int[] parents = new int[size];
        Node[] parentEdge = new Node[size];

        while (true){
            Arrays.fill(parents, -1);
            Queue<Integer> queue = new ArrayDeque<>();
            parents[source] = source;
            queue.add(source);


            while (!queue.isEmpty() && parents[destination] == -1){
                int u = queue.poll();
                for (Node node : adjacencyList[u]){
                    int v = node.destination;
                    if (parents[v] == -1 && node.residualCapacity()>0){
                        parents[v] = u;
                        parentEdge[v] = node;
                        queue.add(v);
                    }
                }

            }

            if (parents[destination] == -1){
                break;
            }

            // find bottleneck
            int bottleneck = Integer.MAX_VALUE;
            for (int v = destination; v != source; v = parents[v]){
                bottleneck = Math.min(bottleneck, parentEdge[v].residualCapacity());
            }

            for (int v = destination; v != source; v = parents[v]){
                parentEdge[v].augment(bottleneck);
            }

            maxFlow += bottleneck;


            List<Integer> path = new ArrayList<>();
            for (int v = destination; v != source; v = parents[v]){
                path.add(v);
            }
            path.add(source);
            Collections.reverse(path);
            System.out.printf("Augmented %d units via %s%n",
                    bottleneck, path);



        }
        System.out.println("Max flow = "+maxFlow);
        return maxFlow;
    }
}
