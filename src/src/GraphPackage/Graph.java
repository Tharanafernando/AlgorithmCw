package GraphPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    int size;
    int[] vertices;
    int[][] adjacencyMatrix;
    List<List<Node>> adjacencyList;




    public Graph(int size) {
        this.size = size;
        vertices = new int[size];


        adjacencyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new LinkedList<>());

        }


    }
    

    public void addVertex(int v){

        vertices[v] = v;

    }
    public void addEdge(int source,int destination,int weight){

        if (source<0 || source>=size || destination<0 || destination>=size){
            throw new IllegalArgumentException("Vertex index out of bounds");
        }

        Node forward = new Node(destination, weight);
        //Node backward = new Node(source, weight,forward);

       // forward.reverse = backward;
        // Create an edge
        adjacencyList.get(source).add(forward);
        //adjacencyList.get(destination).add(backward);




    }





    public void printGraph(){


        for (int i = 0; i < size; i++) {
            System.out.print(i+" ");
            for (Node j: adjacencyList.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }



    }




//    public List<Integer> findPathIterative(int source, int destination, boolean[] visited){
//        if (source<0 || source>size || destination<0 || destination>size){
//            throw new IllegalArgumentException("Vertex index out of bounds");
//        }
//
//
//        if (source == destination){
//            ArrayList<Integer> path = new ArrayList<>();
//            path.add(source);
//            return path;
//        }
//        visited[source] = true;
//
//        for(Node node : adjacencyList.get(source)){
//            int v = node.destination;
//            if (!visited[v]&& node.getWeight()>0){
//                List<Integer>subPath = findPathIterative(v, destination, visited);
//                if (subPath != null){
//                    subPath.add(0,source);
//                    return subPath;
//                }
//            }
//        }
//
//        return null;
//
//    }

    private Node findEdge(int source, int destination){
        for (Node node : adjacencyList.get(source)){
            if (node.getDestination() == destination){
                return node;
            }
        }
        return null;
    }



//    public int fordFulkerson(int source, int sink){
//        int maxFlow = 0;

//        List<Integer> path;
//        while(true){
//            boolean[] visited = new boolean[size];
//            path = findPathIterative(source,sink,visited);
//            if(path==null){
//                break;
//            }
//
//            int pathFlow = Integer.MAX_VALUE;
//            for (int i =0; i<path.size()-1; i++){
//                int u = path.get(i);
//                int v = path.get(i+1);
//                Node forward = findEdge(u,v);
//                pathFlow = Math.min(pathFlow,forward.getWeight());
//
//            }
//
//            for(int i = 0; i<path.size()-1; i++){
//                int u = path.get(i);
//                int v = path.get(i+1);

//                Node forward = findEdge(u,v);
//                forward.setWeight(forward.getWeight()-pathFlow);
//
//                Node back = findEdge(v,u);
//                if (back != null){
//                    back.setWeight(back.getWeight()+pathFlow);
//                }
//                else{
//                    adjacencyList.get(v).add(new Node(u,pathFlow));
//                }
//            }
//
//
//            maxFlow += pathFlow;
//            List<String> pathNames = new ArrayList<>();
//            for (int vertex : path){
//                pathNames.add(String.valueOf(vertex));
//            }
//            // print the path
//            System.out.println("Path: " +
//                    path.stream().map(Object::toString).collect(Collectors.joining(" -> "))
//                    + ", Flow: " + pathFlow);
//        }
//
//        System.out.println("Max flow is: "+maxFlow);
//        return maxFlow;
//    }


    boolean bfs(int source, int destination, int[] parent){
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (Node node : adjacencyList.get(u)){
                int v = node.getDestination();
                if (!visited[v] && node.getWeight()>0){
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                    if (v == destination){
                        return true;
                    }
                }
            }
        }
        return visited[destination];
    }

    public int edmondsKarp(int source, int destination){
        int v , u;
        int[] parent = new int[size];
        int maxFlow = 0;
        while (bfs(source,destination,parent)){
            int pathFlow = Integer.MAX_VALUE;
            for(v = destination; v!=source; v=parent[v]){
                u = parent[v];
                Node forward = findEdge(u,v);
                pathFlow = Math.min(pathFlow,forward.getWeight());
            }
            for (v = destination; v!=source; v=parent[v]){
                u = parent[v];
                Node forward = findEdge(u,v);
                forward.setWeight(forward.getWeight()-pathFlow);
                Node back = findEdge(v,u);
                if (back != null){
                    back.setWeight(back.getWeight()+pathFlow);
                }else {
                    adjacencyList.get(v).add(new Node(u,pathFlow));
                }
            }
            maxFlow += pathFlow;



            LinkedList<String> pathNames = new LinkedList<>();
            for (int y = destination; y != source; y = parent[y]) {
                pathNames.addFirst(String.valueOf(vertices[y]));
            }
            pathNames.addFirst(String.valueOf(vertices[source]));
            System.out.println("Path: " +
                    String.join(" -> ", pathNames) +
                    ", Flow: " + pathFlow);


        }
        System.out.println("Max flow is: "+maxFlow);
        return maxFlow;
    }



}
