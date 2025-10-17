package pl.paulina.restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable {
    private LocalDate orderDate;
    private List<OrderItem> orderItems = new ArrayList<>();
    private OrderStatus status = OrderStatus.PREPARING;
    private Client client;

    public Order(Client client, LocalDate orderDate, OrderStatus status) {
        this.client = client;
        this.orderDate = orderDate;
        this.status = status;
    }

    public void addOrderItem(Dish dish) {
        OrderItem item = new OrderItem(this, dish);
        orderItems.add(item);
    }

    public List<OrderItem> getOrderedItems() {
         return orderItems;
    }

    public String printOrderDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order").append("date" + "\t" + orderDate).append("\t" +status);

        return stringBuilder.toString();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;

    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }
}

