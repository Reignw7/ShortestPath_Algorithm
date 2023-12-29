import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {

    int nodes;
    LinkedList<String> list [];

    public AdjacencyList(int nodes){
         this.nodes=nodes;
        list = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            list[i] = new LinkedList<>();
        }
    }

}
