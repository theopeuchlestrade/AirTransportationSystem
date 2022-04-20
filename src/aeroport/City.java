package aeroport;

import java.util.ArrayList;
import java.util.List;

public class City {

    private final String name;

    /* external links */
    private List<Airport> airports = new ArrayList<>();

    /* Constructor */

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void removeAirport(Airport airport) {
        this.airports.remove(airport);
    }

    public void addAirport(Airport airport) {
        this.airports.add(airport);
    }

    @Override
    public String toString() {
        return "";
    }

}
