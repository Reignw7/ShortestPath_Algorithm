import java.util.ArrayList;
import java.util.Collections;

public class BellmanFordGraph {

    private ArrayList<House> houses;
    private ArrayList<Distance> distances;

    public BellmanFordGraph(ArrayList<Distance> distances, ArrayList<House> houses) {
        this.distances = distances;
        this.houses = houses;
    }

    private void relax(House houseFrom, House houseTo, double weight) {
        if (houseFrom.getDistance() + weight < houseTo.getDistance()) {
            houseTo.setDistance(houseFrom.getDistance() + weight);
            houseTo.setPreviousHouse(houseFrom);
        }
    }

    private void initializeSingleSource(House source) {
        for (House house : houses) {
            house.setDistance(Double.MAX_VALUE);
            house.setPreviousHouse(null);
        }
        source.setDistance(0);
    }

    public void bellmanFord(House source) {
        initializeSingleSource(source);

        // Relax all edges repeatedly
        for (int i = 0; i < houses.size() - 1; i++) {
            for (Distance distance : distances) {
                relax(distance.getHouseFrom(), distance.getHouseTo(), distance.getDistance());
            }
        }

        // Check for negative weight cycles
        for (Distance distance : distances) {
            if (distance.getHouseTo().getDistance() > distance.getHouseFrom().getDistance() + distance.getDistance()) {
                System.out.println("Graph contains negative weight cycle");
                System.exit(0); // Exit the program
            }
        }
    }

    public String getShortestPath(House destination) {
        ArrayList<String> path = new ArrayList<>();
        House currentHouse = destination;

        while (currentHouse != null) {
            path.add(currentHouse.getName());
            currentHouse = currentHouse.getPreviousHouse();
        }

        Collections.reverse(path);

        return String.join(" > ", path);
    }

    public static void main(String[] args) {

        ArrayList<House> houseList = new ArrayList<>();
        houseList.add(new House("A")); //0
        houseList.add(new House("B")); //1
        houseList.add(new House("C")); //2
        houseList.add(new House("D")); //3
        houseList.add(new House("E")); //4


        ArrayList<Distance> distanceList = new ArrayList<>();

        distanceList.add(new Distance(2, houseList.get(0), houseList.get(1)));
        distanceList.add(new Distance(4, houseList.get(0), houseList.get(2)));
        distanceList.add(new Distance(1, houseList.get(1), houseList.get(3)));
        distanceList.add(new Distance(3, houseList.get(2), houseList.get(3)));
        distanceList.add(new Distance(5, houseList.get(2), houseList.get(4)));



        BellmanFordGraph bellmanFordGraph = new BellmanFordGraph(distanceList, houseList);
        bellmanFordGraph.bellmanFord(houseList.get(0));

        House destinationHouse = houseList.get(4);
        String shortestPath = bellmanFordGraph.getShortestPath(destinationHouse);
        System.out.println("Shortest path from " + houseList.get(0).getName() +
                " to " + destinationHouse.getName() + ": " + shortestPath);


    }
}
