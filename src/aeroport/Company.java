package aeroport;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;

    /* external links */
    private List<Flight> flights = new ArrayList<>();

    /* Constructor */

    public Company(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
    }

    @Override
    public String toString() {
        return "";
    }
}
