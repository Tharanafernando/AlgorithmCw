package GraphPackage;

public class Graph {
    int size;
    int[] vertices;
    int[][] adjacencyMatrix;

    public Graph(int size) {
        this.size = size;
        vertices = new int[size];
        adjacencyMatrix = new int[size][size];
    }


    public void addVertex(int v,int u){
        boolean vExists = false;
        boolean uExists = false;
        for (int i = 0; i < vertices.length; i++) {
           if (uExists == true){

           }
           vertices[i]=v;
           vertices[i++] = u;
           uExists = true;


        }



    }
    public void addEdge(int source,int destination,int weight){

    }
}
