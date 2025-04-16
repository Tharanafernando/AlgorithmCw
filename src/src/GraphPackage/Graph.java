package GraphPackage;

import java.util.Stack;

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


    public void dfs(int startingVertex){
        boolean[] visited = new boolean[size];
        dfs_util(visited,startingVertex);
        System.out.println();

    }


    
}
