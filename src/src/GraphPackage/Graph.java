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
        boolean found = false;

        vertices[v] = v;
//        boolean found = false;
//        vertices[v] = v;
//
//        int findValue = vertices.length - 1;
//        for(int i = 0; i < vertices.length; i++){
//
//            if(vertices[i] == v){
//                found = true;
//            }
//
//            if (i==findValue){
//                if (vertices[i] == 0){
//                    vertices[findValue] = vertices[findValue-1]++;
//                }
//            }
//
//
//        }

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

        System.out.println();
        System.out.println("Vertices are: ");

        for(int i : vertices){

            System.out.print(i+" ");
        }
    }
}
