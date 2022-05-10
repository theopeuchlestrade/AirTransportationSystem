package reservation;

import aeroport.Flight;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Reservation {

    /* private fields  */
    private String reservationNumber; // unique
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
        this.reservationNumber = generateNewReservationNumber();
    }

    public String generateNewReservationNumber() {
        return UUID.randomUUID().toString();
    }

    public void cancel() {
        // TODO
    }

    public void reserve() {
        // TODO
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "  reservationNumber=" + reservationNumber +
                ", date=" + date +
                ", flight=" + flight +
                ", client=" + client +
                ", passenger=" + passenger +
                '}';
    }
}
