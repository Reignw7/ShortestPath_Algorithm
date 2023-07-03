import java.util.ArrayList;

public class House {
    private String name;
    private boolean visited;
    private double distance = Double.MAX_VALUE;
    private House previousHouse;
    private ArrayList<Distance> Distances; //adjacency list


    public House(String name) {
        this.name = name;
        this.Distances = new ArrayList<>();
    }

    public void addDistance(Distance distance){
        this.Distances.add(distance);
    }

    //getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public House getPreviousHouse() {
        return previousHouse;
    }

    public void setPreviousHouse(House previousHouse) {
        this.previousHouse = previousHouse;
    }

    public ArrayList<Distance> getDistances() {
        return Distances;
    }

    public void setDistances(ArrayList<Distance> distances) {
        Distances = distances;
    }
}
