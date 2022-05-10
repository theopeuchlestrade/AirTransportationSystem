package aeroport;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private final String name;

    /* extern link */
    private List<City> cities = new ArrayList<>();

    /* Constructor  */
    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public void removeCity(City city) {
        this.cities.remove(city);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
