import java.util.ArrayList;

public class Graph {
    public ArrayList<Airport> airports;
    public int numAirports;
    public int numNodes;
    public int maxNum;

    public Graph(){
        int max = 10;
        maxNum = max;
        airports = new ArrayList<Airport>(maxNum);
        numAirports = 0;

    }

    public final void addAirport(String name){
        airports.add(new Airport(name));
    }

    public final void addNetwork (String airPortTo, String airPortFrom, int cost){
        int index = indexOf(airPortFrom);
        Airport a = airports.get(index);
        network newNetwork = new network(airPortFrom, cost);
        a.getNetworks().add(newNetwork);
    }

    public int indexOf(String name){

        return  airports.indexOf(name);
    }

    public static void main(String args[]){
        Graph DijkstraMap = new Graph();

        DijkstraMap.addAirport("CPT");
        DijkstraMap.addAirport("DUR");
        DijkstraMap.addAirport("KZN");

        System.out.println(DijkstraMap.airports.get(0).name);
        System.out.println(DijkstraMap.airports.get(1).name);
        System.out.println(DijkstraMap.airports.get(2).name);


    }

}
