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


    /* Constructor */
    public Company() {
        this.name = "";
    }

    public void addFlight(Flight flight) {
        flight.setCompany(this);
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
    }


    public List<Flight> getFlights() {
        return flights;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (this.name.isBlank()) {
            return "no name";
        }

        return name;

    }

    @Override
    public String toString() {
        return "Name = " + this.name + "\n" +
                "Flights : " + this.flights;
    }
}
