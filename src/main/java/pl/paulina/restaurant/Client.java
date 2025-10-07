package pl.paulina.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private String customerId;
    private String name;
    private List<Order> orders = new ArrayList<>();

    Client(String name) {
        this.customerId = String.valueOf(UUID.randomUUID());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order placeOrder(LocalDate date) {
        Order order = new Order(this.customerId, date, Status.PREPARING);
        orders.add(order);
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
