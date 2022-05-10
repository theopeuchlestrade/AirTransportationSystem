package reservation;

import java.util.UUID;

public class Client extends Person {

    private String contact;
    private PaymentMethod paymentMethod;
    private String reference;

    /* Constructor  */
    public Client(String name, String contact, PaymentMethod paymentMethod) {
        super(name);
        this.setName(name);
        this.contact = contact;
        this.paymentMethod = paymentMethod;
        this.reference = generateNewReference();

    }

    public String generateNewReference() {
        return UUID.randomUUID().toString();
    }

    public String getReference() {
        return reference;
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
