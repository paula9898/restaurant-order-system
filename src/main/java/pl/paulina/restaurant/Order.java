package pl.paulina.restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //private final int orderNumber;
    private LocalDate orderDate;
    private List<OrderItem> orderItems = new ArrayList<>();
    private final String customerId;

    public Order(String customerId,LocalDate orderDate) {
        this.orderDate = orderDate;
        this.customerId = customerId;

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
}
