package reservation;

import java.util.ArrayList;
import java.util.List;

public class Person {

    /* private fields */
    private String name;

    /* external links */
    private List<Reservation> reservations = new ArrayList<>();

    public Person(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    ;

    public void removeReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

    ;
}
