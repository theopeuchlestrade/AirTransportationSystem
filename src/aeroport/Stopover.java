package aeroport;

import java.util.Date;

public class Stopover extends Airport {

    private Date start;
    private Date end;
    private Long duration;

    public Stopover(String name, Date start, Date end) {

        super(name);
        this.start = start;
        this.end = end;
    }

    public void computeDuration() {
        // TODO
    }

    public void setStart(Date start, Date end) {
        // TODO
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
