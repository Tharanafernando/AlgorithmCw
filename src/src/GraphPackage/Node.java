package GraphPackage;

public class Node {
    int destination; // target node
    int weight; // original capacity
    int flow; // current flow
    Node reverse;


    Node(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.flow = 0;


    }


    public int getWeight() {
        return weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getFlow() {
        return flow;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
    public void setFlow(int flow) {
        this.flow = flow;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String toString(){
        return String.format("%d(w=%d)", destination, weight);
    }

}
