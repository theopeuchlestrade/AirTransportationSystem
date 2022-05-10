

import aeroport.Company;
import aeroport.Flight;
import aeroport.Stopover;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


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

        // 2022/01/01 : 00h00
        LocalDateTime localENDateTime = LocalDateTime.of(2022, Month.JANUARY, 1, 0, 0, 0);
        // 2022/01/01 : 19h00
        LocalDateTime localAUDateTime2 = LocalDateTime.of(2022, Month.JANUARY, 1, 19, 0, 0);
        // 2022/01/01 : 22h00
        LocalDateTime localCODateTime2 = LocalDateTime.of(2022, Month.JANUARY, 1, 22, 0, 0);

        ZoneId enZoneId = ZoneId.of("Europe/London");
        ZoneId auZoneId = ZoneId.of("Australia/Brisbane");
        ZoneId coZoneId = ZoneId.of("Asia/Seoul");

        ZonedDateTime enDateTime = ZonedDateTime.of(localENDateTime, enZoneId);
        ZonedDateTime auDateTime = ZonedDateTime.of(localAUDateTime2, auZoneId);
        ZonedDateTime coDateTime = ZonedDateTime.of(localCODateTime2, coZoneId);

        Stopover brisbane = new Stopover("Brisbane", new Date(), new Date());
        Stopover london = new Stopover("London", new Date(), new Date());
        Stopover busan = new Stopover("Busan", new Date(), new Date());

        Flight superLongFlight = new Flight();


        try {
            superLongFlight.setStart(enDateTime, enDateTime);

        } catch (Exception e) {
            throw new RuntimeException("Unable to format to date");
        }


        superLongFlight.addStopover(brisbane);
        superLongFlight.addStopover(london);
        superLongFlight.addStopover(busan);

        superLongFlight.displayStopOvers();

    }
}
