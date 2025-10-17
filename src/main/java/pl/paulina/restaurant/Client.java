package pl.paulina.restaurant;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client implements Serializable {
    private String name;
    private List<Order> orders = new ArrayList<>();

    Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                '}';
    }

    public Order placeOrder(LocalDate date) {
        Order order = new Order(this,date, OrderStatus.PREPARING);
        orders.add(order);
        return order;
    }
}
