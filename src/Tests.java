import aeroport.Airport;
import aeroport.Flight;
import aeroport.Stopover;
import org.junit.jupiter.api.Test;
import reservation.Client;
import reservation.PaymentMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testTotalStepOverDuration() throws ParseException {

        Flight testFlight = new Flight();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Stopover step1 = new Stopover("Berlin", formatter.parse("21/07/2022 00:00:00"), formatter.parse("21/07/2022 01:00:00"));
        Stopover step2 = new Stopover("London", formatter.parse("21/07/2022 01:00:00"), formatter.parse("21/07/2022 02:00:00"));
        Stopover step3 = new Stopover("Tokyo", formatter.parse("21/07/2022 02:00:00"), formatter.parse("21/07/2022 03:00:00"));
        Stopover step4 = new Stopover("Paris", formatter.parse("21/07/2022 04:00:00"), formatter.parse("21/07/2022 05:00:00"));


        for (Stopover step : Arrays.asList(step1, step2, step3, step4)) {
            testFlight.addStopover(step);
        }

        assertEquals(testFlight.getDuration(), 4 * 60 * 60 * 1000);
    }

    @Test
    public void testCloseFlight() {

        Airport start = new Airport("Paris Charles de Gaulle");
        Airport end = new Airport("Tokyo-Haneda");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        ZonedDateTime asiaDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        Flight testFlight = new Flight(europeDateTime, asiaDateTime, start, end);
        assertTrue(testFlight.getStatus());
        testFlight.closeReservation();
        assertFalse(testFlight.getStatus());

    }

    @Test
    public void testOpenFlight() {

        Airport start = new Airport("Berlin");
        Airport end = new Airport("Los Angeles");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        ZonedDateTime usDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        Flight testFlight = new Flight(europeDateTime, usDateTime, start, end);
        assertTrue(testFlight.getStatus());
        testFlight.closeReservation();
        testFlight.openReservation();
        assertTrue(testFlight.getStatus());

    }

    @Test
    public void testSimpleFlightDuration() {

        Flight test = new Flight();

        ZonedDateTime startZonedDateTime = ZonedDateTime.parse("2011-12-03T10:15:30+01:00");
        ZonedDateTime entZonedDateTime = ZonedDateTime.parse("2011-12-03T11:15:30+01:00");

        test.setStart(startZonedDateTime, entZonedDateTime);

        assertEquals(60 * 60 * 1000, test.getDuration());

    }


    @Test
    public void testFlightID() {

        Flight test1 = new Flight();
        Flight test2 = new Flight();

        assertNotEquals(test1.getFlightID(), test2.getFlightID());

    }

    @Test
    public void testClientID() {

        Client test1 = new Client("Theo", "Dorian", PaymentMethod.CASH);
        Client test2 = new Client("Dorian", "Theo", PaymentMethod.CARD);

        assertNotEquals(test1.getReference(), test2.getReference());

    }

}
