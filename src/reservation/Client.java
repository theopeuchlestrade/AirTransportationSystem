package reservation;

public class Client extends Person {

    private String contact;
    private String reference;

    /* Constructor  */
    public Client(String name, String contact, PaymentMethod paymentMethod) {

        super(name);
        this.contact = contact;
    }

    public String generateNewReference() {
        // TODO implement
        return "";
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + super.getName() + '\'' +
                "contact='" + contact + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
