package aeroport;

import java.security.Timestamp;
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
        this.flightID = generateID();
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
        this.computeDuration();  // force update
        return this.duration;
    }

    public void openReservation() {
        this.isOpen = true;
    }

    public boolean getStatus(){
        return this.isOpen;
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

        // Compute time based on given stepover.
        if(!stopovers.isEmpty()) {
            System.out.println("This flight has several steps.");
            for (Stopover step : this.stopovers) {
                this.duration += step.getDuration();
            }
        }

        // Compute time by given a start and stop date.
        if (this.start != null && this.end != null) {

            this.duration = ChronoUnit.MILLIS.between(this.start, this.end);
        }
    }

    public void displayStopOvers(){

        for (int i = 0; i < this.stopovers.size(); i++) {

            if (i==0) {
                System.out.println("Début : "+ this.stopovers.get(i).getName() + " à " + this.start);
                drawStep();
            }

            else if (i == this.stopovers.size() - 1  ) {
                System.out.println("Fin : " + this.stopovers.get(i).getName()+ " à " + this.end);
            } else {
                System.out.println("Escale à : " + this.stopovers.get(i).getName());
                drawStep();
            }


        }

    }

    private void drawStep(){
        System.out.println("| |");
        System.out.println("| |");
        System.out.println("| |");
        System.out.println(" V ");
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
