public class Distance {
    private double distance;
    private House houseFrom;
    private House houseTo;

    public Distance(int distance, House houseFrom, House houseTo) {
        this.distance = distance;
        this.houseFrom = houseFrom;
        this.houseTo = houseTo;
    }

    public House getHouseTo() {
        return houseTo;
    }

    public House getHouseFrom() {
        return houseFrom;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setHouseFrom(House houseFrom) {
        this.houseFrom = houseFrom;
    }

    public void setHouseTo(House houseTo) {
        this.houseTo = houseTo;
    }
}
