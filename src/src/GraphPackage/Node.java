/*
 Name :  Tharana Sandul Fernando
 UOW  :   w2051566    ,    IIT  :  20230147

*/

package GraphPackage;

public class Node {

    public int destination;
    int capacity;
    int flow;
    Node reverse;


    Node(int destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.flow = 0;



    }



    public int residualCapacity() {
      return capacity - flow;
    }


    public void augment(int bottle) {
        flow+=bottle;
        reverse.flow -= bottle;
    }

    public String toString(){
        return String.format("%d(w=%d)", destination, capacity);
    }





}
