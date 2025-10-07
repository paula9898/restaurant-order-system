package pl.paulina.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    //private final int orderNumber;
    private LocalDate orderDate;
    private List<OrderItem> orderItems = new ArrayList<>();
    private final String customerId;
    private Status status = Status.PREPARING;
    private String orderId;

    public Order(String customerId,LocalDate orderDate, Status status) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.status = status;
        this.orderId =  String.valueOf(UUID.randomUUID());
    }

    public OrderItem addOrderItem(Dish dish) {
        OrderItem item = new OrderItem(dish);
        orderItems.add(item);

        return item;
    }

    public void printOrderedItems(String customerId) {
         for(int i = 0; i < orderItems.size(); i++) {
             System.out.println(orderItems.get(i));
         }
    }

    public String printOrderDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order").append("date" + "\t" + orderDate).append("\t" +status);

        return stringBuilder.toString();
    }

    public void setStatus(Status status) {
        this.status = status;

    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}

