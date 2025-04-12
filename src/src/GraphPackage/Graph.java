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







    public void addVertex(int v){

        for (int i = 0; i<size; i++){

            if (vertices[i] != v){
                vertices[i] = v;
            }


        }


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
}
