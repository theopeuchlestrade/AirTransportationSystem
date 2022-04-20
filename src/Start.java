

import aeroport.Company;
import aeroport.Flight;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Start {

    public static void main(String[] args) {
        Flight volFinal = new Flight();

        /* ZonedDateTime */
        LocalDateTime localDateTime = LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2000, Month.JANUARY, 1, 9, 36, 0);

        ZoneId frZoneId = ZoneId.of("Europe/Paris");
        ZoneId vnZoneId = ZoneId.of("Asia/Ho_Chi_Minh");

        ZonedDateTime frDateTime = ZonedDateTime.of(localDateTime, frZoneId);
        ZonedDateTime vnDateTime = ZonedDateTime.of(localDateTime2, vnZoneId);

        try {
            volFinal.setStart(frDateTime, vnDateTime);

        } catch (Exception e) {
            throw new RuntimeException("Unable to format to date");
        }

        volFinal.computeDuration();
        System.out.println(volFinal.getEnd());
        System.out.println(volFinal.getDuration());


        //Bidirectional
        Flight vol = new Flight();
        vol.setFlightID("abc1");

        Flight vol2 = new Flight();
        vol2.setFlightID("abc2");

        Company compagnie = new Company("Air France");
        compagnie.addFlight(vol);
        compagnie.addFlight(vol2);

        for (Flight v : compagnie.getFlights()) {
            System.out.println(v.getFlightID());
        }

        System.out.println(vol.getCompany().getName());
        System.out.println(vol2.getCompany().getName());

        vol2.setCompany(null);
        System.out.println(vol2.getCompany());

        for (Flight v : compagnie.getFlights()) {
            System.out.println(v.getFlightID());
        }
    }
}
