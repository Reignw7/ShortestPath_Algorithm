import java.util.*;

public class Graph {
    public ArrayList<Airport> airports;

    public Graph() {
         this.airports = new ArrayList<>();
    }

    // Method to add an airport to the graph.
    public void addAirport(String name) {
        airports.add(new Airport(name));
    }

    // Method to get an airport by its name.
    public Airport getAirportByName(String name) {
        for (Airport airport : airports) {
            if (airport.name.equals(name)) {
                return airport;
            }
        }
        return null;
    }

    // Method to add a network (edge) between two airports with a given cost.
    public void addNetwork(String airportFrom, String airportTo, int cost) {
        Airport from = getAirportByName(airportFrom);
        Airport to = getAirportByName(airportTo);

        if (from != null && to != null) {
            from.getNetworks().add(new Network(airportTo, cost));
            to.getNetworks().add(new Network(airportFrom, cost));
        }
    }

    // Dijkstra's algorithm to find the shortest paths from a starting airport.
    public void dijkstra(String startAirportName, String endAirportName) {
        Airport startAirport = getAirportByName(startAirportName);
        Airport endAirport = getAirportByName(endAirportName);
        if (startAirport == null || endAirport == null) {
            System.out.println("Airport not found.");
            return;
        }

        Map<Airport, Double> distances = new HashMap<>();
        Map<Airport, LinkedList<Airport>> paths = new HashMap<>();
        for (Airport airport : airports) {
            distances.put(airport, Double.POSITIVE_INFINITY);
            paths.put(airport, new LinkedList<>());
        }
        distances.put(startAirport, 0.0);

        PriorityQueue<Airport> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        priorityQueue.add(startAirport);

        while (!priorityQueue.isEmpty()) {
            Airport currentAirport = priorityQueue.poll();

            for (Network connection : currentAirport.getNetworks()) {
                Airport neighbor = getAirportByName(connection.name);
                double newDistance = distances.get(currentAirport) + connection.cost;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    LinkedList<Airport> newPath = new LinkedList<>(paths.get(currentAirport));

                    // Add the previous airport to the path
                    newPath.add(currentAirport);

                    paths.put(neighbor, newPath);

                    // Add the destination airport to the path when reached
                    if (neighbor.equals(endAirport)) {
                        newPath.add(endAirport);
                    }

                    priorityQueue.add(neighbor);
                }
            }
        }

        LinkedList<Airport> shortestPath = paths.get(endAirport);
        if (shortestPath == null || shortestPath.isEmpty()) {
            System.out.println("No path found from " + startAirport.name + " to " + endAirport.name);
            return;
        }

        System.out.print("Shortest path from " + startAirport.name + " to " + endAirport.name + ": ");
        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.print(shortestPath.get(i).name);
            if (i < shortestPath.size() - 1) {
                System.out.print(" > ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph dijkstraMap = new Graph();

        // Add airports
        dijkstraMap.addAirport("A");
        dijkstraMap.addAirport("B");
        dijkstraMap.addAirport("C");
        dijkstraMap.addAirport("D");
        dijkstraMap.addAirport("E");

        // Add networks (connections)
        dijkstraMap.addNetwork("A", "B", 4);
        dijkstraMap.addNetwork("A", "C", 2);
        dijkstraMap.addNetwork("B", "C", 1);
        dijkstraMap.addNetwork("B", "D", 2);
        dijkstraMap.addNetwork("C", "D", 3);
        dijkstraMap.addNetwork("C", "E", 5);
        dijkstraMap.addNetwork("E", "D", 1);

        dijkstraMap.dijkstra("A", "E");
    }
    

}
