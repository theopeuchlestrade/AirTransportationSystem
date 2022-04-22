package reservation;

import aeroport.Flight;

import java.time.ZonedDateTime;

public class Reservation {

    /* private fields  */
    private Integer reservationNumber; // unique
    private ZonedDateTime date;

    /* external links  */

    private Flight flight;
    private Client client;
    private Passenger passenger;

    /* Constructor */
    public Reservation(Flight flight, Client client, Passenger passenger) {
        this.client = client;
        this.passenger = passenger;
        this.flight = flight;
    }

    public String generateNewReservationNumber() {
        return "";
    }

    public void cancel() {

    }

    public void reserve() {

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationNumber=" + reservationNumber +
                ", date=" + date +
                ", flight=" + flight +
                ", client=" + client +
                ", passenger=" + passenger +
                '}';
    }
}
