package GraphPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    int size;
    int[] vertices;
    int[][] adjacencyMatrix;



    public Graph(int size) {
        this.size = size;
        vertices = new int[size];
        adjacencyMatrix = new int[size][size];
    }







    public void addVertex(int v){


        vertices[v] = v;

    }
    public void addEdge(int source,int destination,int weight){
        if (source<size&&destination<size){
            adjacencyMatrix[source][destination]=weight;
        }

    }

    public void printGraph(){


        for (int[] matrix:adjacencyMatrix){
            for(int v:matrix){
                System.out.print(v+" ");
            }
            System.out.println();
        }


    }

    public void dfs_util(boolean[]visited,int source){
        visited[source]=true;
        System.out.print(vertices[source]+" ");
        for (int i =0; i< size; i++){
            if(adjacencyMatrix[source][i]!=0 && !visited[i]){
                dfs_util(visited,i);
            }
        }
    }


    public List<Integer> findPathIterative(int source, int destination, boolean[] visited){
        int[]parent=new int[size];
        Arrays.fill(parent,-1);

        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(source);
        visited[source]=true;

        while (!stack.isEmpty()){
            int u=stack.pop();
            if (u==destination){
                break;
            }

            for(int v = 0; v<size; v++ ){
                if (adjacencyMatrix[u][v]>0 && !visited[v]){
                    visited[v]=true;
                    parent[v]=u;
                    stack.push(v);
                }
            }
        }

        if (parent[destination]==-1){
            return null;
        }

        List<Integer> path=new ArrayList<>();
        for (int v = destination; v!=-1; v= parent[v]){
            path.add(v);
        }
        Collections.reverse(path);
        return path;

//        if(source==destination){
//            List<Integer> path = new ArrayList<>();
//            path.add(source);
//            return path;
//        }
//        visited[source]=true;
//        for (int i =0; i< size; i++){
//
//            if(adjacencyMatrix[source][i]!=0 && !visited[i]){
//                List<Integer> subPath = findPathIterative(i,destination,visited);
//                if(subPath!=null){
//                    subPath.add(0,source);
//                    return subPath;
//                }
//            }
//        }
//
//        return null;
    }



    public int fordFulkerson(int source, int sink){
        int maxFlow = 0;

        List<Integer> path;
        while(true){
            boolean[] visited = new boolean[size];
            path = findPathIterative(source,sink,visited);
            if(path==null){
                break;
            }

            int pathFlow = Integer.MAX_VALUE;
            for (int i =0; i<path.size()-1; i++){
                int u = path.get(i);
                int v = path.get(i+1);
                pathFlow = Math.min(pathFlow,adjacencyMatrix[u][v]);
            }

            for(int i = 0; i<path.size()-1; i++){
                int u = path.get(i);
                int v = path.get(i+1);
                adjacencyMatrix[u][v] -= pathFlow;
                adjacencyMatrix[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
            // print the path
            System.out.println("Path: " +
                    path.stream().map(Object::toString).collect(Collectors.joining(" -> "))
                    + ", Flow: " + pathFlow);
        }

        System.out.println("Max flow is: "+maxFlow);
        return maxFlow;
    }



}
