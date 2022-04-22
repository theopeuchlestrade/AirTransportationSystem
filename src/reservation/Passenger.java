package reservation;

public class Passenger extends Person {


    public Passenger(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + super.getName() + '\'' +
                '}';
    }
}
