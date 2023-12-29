import java.util.List;

public class Airport {
    public String name;
    public List<Network> networks;

    public Airport(String name) {
        this.name = name;
        this.networks = new java.util.ArrayList<>();
    }

    public List<Network> getNetworks() {
        return this.networks;
    }
}
