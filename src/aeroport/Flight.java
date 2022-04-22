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


    /* setCompanyWithoutBidirectional */
    private Company company = new Company();


    /* Constructor */

    public Flight() {

    }

    /* Constructor */
    public Flight(ZonedDateTime start, ZonedDateTime end, Airport startAirport, Airport endAirport) {

        this.flightID = generateID();
        this.start = start;
        this.end = end;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.isOpen = true; // open reservation by default

    }

    public String generateID() {
        return UUID.randomUUID().toString();
    }

    public String getFlightID() {
        return flightID;
    }

    public long getDuration() {
        return duration;
    }

    public void openReservation() {
        this.isOpen = true;
    }

    public void closeReservation() {
        this.isOpen = false;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setStart(ZonedDateTime start, ZonedDateTime end) {
        this.start = start;
        this.end = end;
        this.computeDuration();
    }

    public void computeDuration() {

        if (this.start != null && this.end != null) {
            this.duration = Duration.of(end.getNano() - start.getNano(), ChronoUnit.NANOS).toMillis();
        }
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void addStopover(Stopover stopover) {
        this.stopovers.add(stopover);
    }

    public void removeStopover(Stopover stopover) {
        this.stopovers.remove(stopover);
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightID='" + flightID + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                ", isOpen=" + isOpen +
                ", stopovers=" + stopovers +
                ", startAirport=" + startAirport +
                ", endAirport=" + endAirport +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((Flight) obj).getFlightID().equals(this.flightID);
        } catch (Exception e) {
            return false;
        }
    }
}
