import java.util.ArrayList;

public class Graph {
    public ArrayList<Airport> airports;

    public Graph() {
         this.airports = new java.util.ArrayList<>();
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
    public void dijkstra(String startAirportName) {
        Airport startAirport = getAirportByName(startAirportName);
        if (startAirport == null) {
            System.out.println("Airport not found: " + startAirportName);
            return;
        }

        Map<Airport, Double> distances = new HashMap<>();
        for (Airport airport : airports) {
            distances.put(airport, Double.POSITIVE_INFINITY);
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
                    priorityQueue.add(neighbor);
                }
            }
        }

        for (Airport airport : airports) {
            System.out.println("Shortest distance from " + startAirport.name + " to " + airport.name + ": " + distances.get(airport));
        }
    }

    public static void main(String[] args) {
        Graph dijkstraMap = new Graph();

        dijkstraMap.addAirport("CPT");
        dijkstraMap.addAirport("DUR");
        dijkstraMap.addAirport("KZN");

        dijkstraMap.addNetwork("CPT", "DUR", 2);
        dijkstraMap.addNetwork("CPT", "KZN", 5);
        dijkstraMap.addNetwork("DUR", "KZN", 1);

        dijkstraMap.dijkstra("CPT");
    }
    

}
