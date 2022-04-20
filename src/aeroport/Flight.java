package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Flight {

    private String flightID; // id unique
    private ZonedDateTime start;
    private ZonedDateTime end;
    private long duration;
    private boolean isOpen;

    /* external links */
    private List<Stopover> stopovers = new ArrayList<>();
    private Airport startAirport = null;
    private Airport endAirport = null;

    /* Constructor */

    public Flight() {

    }

    public String generateID() {
        return UUID.randomUUID().toString();
    }

    public void openReservation() {

    }

    public void closeReservation() {

    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public long computeDuration() {
        // TODO
        if (this.start != null && this.end != null) {
            return Duration.of(end.getTime() - start.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public void addStopover(Stopover stopover) {
        this.stopovers.add(stopover);
    }

    public void removeStopover(Stopover stopover) {
        this.stopovers.remove(stopover);
    }

    @Override
    public String toString() {
        return "";
    }
}
