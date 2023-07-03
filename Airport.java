import java.util.LinkedList;

public class Airport {
    public  String name;
    public LinkedList<network> networks;
    public  Airport parent;

    public Airport (String name){
        this.name = name;
        networks = new LinkedList<network>();
    }

    public LinkedList<network> getNetworks(){
        return this.networks;
    }

}


