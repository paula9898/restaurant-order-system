package pl.paulina.restaurant;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private String customerId;
    private String name;

    Client(String name) {
        this.customerId = String.valueOf(UUID.randomUUID());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order placeOrder(LocalDate date) {
        Order order = new Order(this.customerId, date);

        return order;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
