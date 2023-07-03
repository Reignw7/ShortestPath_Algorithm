import java.util.ArrayList;

public class test {



    public static void main(String args[]){

        ArrayList<House> houseList = new ArrayList<>();

        houseList.add(new House("A"));
        houseList.add(new House("B"));
        houseList.add(new House("C"));
        houseList.add(new House("D"));

        ArrayList<Distance> distanceList = new ArrayList<>();

        distanceList.add(new Distance(2, houseList.get(0), houseList.get(1)));
        distanceList.add(new Distance(7, houseList.get(0), houseList.get(2)));
        //distanceList.add(new Distance(2, houseList.get(0), houseList.get(3)));
        distanceList.add(new Distance(3, houseList.get(1), houseList.get(3)));
        distanceList.add(new Distance(1, houseList.get(2), houseList.get(3)));

        Graph bellmanFord = new Graph(distanceList, houseList);

        bellmanFord.bellmanFord(houseList.get(0));
        bellmanFord.shortestPath(houseList.get(3));

    }
}
