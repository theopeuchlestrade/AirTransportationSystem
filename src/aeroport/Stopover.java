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
        this.computeDuration(); // update if necessary
    }

    public void computeDuration() {
        if (this.start != null && this.end != null) {
            this.duration = end.getTime() - start.getTime() ;
        }
    }

    public void setStart(Date start, Date end) {
        this.start = start;
        this.end = end;
        this.computeDuration(); // force update
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return  "Stopover : " + "\n" +
                "Start date : " + start + "\n" +
                "End date : " + end  + "\n" ;

    }
}
