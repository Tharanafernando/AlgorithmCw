package GraphPackage;

import java.util.*;
import java.util.stream.Collectors;

public class FordFulkerson {
    private int size;

    public FordFulkerson(int size) {
        this.size = size;
    }

//    public List<Integer> findPathIterative(int source, int destination, boolean[] visited){
//        int[]parent=new int[size];
//        Arrays.fill(parent,-1);
//
//        Stack<Integer> stack=new Stack<>();
//        stack.push(source);
//        visited[source]=true;
//
//        while (!stack.isEmpty()){
//            int u=stack.pop();
//            if (u==destination){
//                break;
//            }
//
//            for(int v = 0; v<size; v++ ){
//                if (adjacencyMatrix[u][v]>0 && !visited[v]){
//                    visited[v]=true;
//                    parent[v]=u;
//                    stack.push(v);
//                }
//
//            }
//        }
//
//        if (parent[destination]==-1){
//            return null;
//        }
//
//        List<Integer> path=new ArrayList<>();
//        for (int v = destination; v!=-1; v= parent[v]){
//            path.add(v);
//        }
//        Collections.reverse(path);
//        return path;
//
//
//    }
//
//
//    public int fordFulkerson(int source, int sink){
//        int maxFlow = 0;
//
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
//                pathFlow = Math.min(pathFlow,adjacencyMatrix[u][v]);
//
//            }
//
//            for(int i = 0; i<path.size()-1; i++){
//                int u = path.get(i);
//                int v = path.get(i+1);
//                adjacencyMatrix[u][v] -= pathFlow;
//                adjacencyMatrix[v][u] += pathFlow;
//            }
//            maxFlow += pathFlow;
//            // print the path
//            System.out.println("Path: " +
//                    path.stream().map(Object::toString).collect(Collectors.joining(" -> "))
//                    + ", Flow: " + pathFlow);
//        }
//
//        System.out.println("Max flow is: "+maxFlow);
//        return maxFlow;
//    }
}
