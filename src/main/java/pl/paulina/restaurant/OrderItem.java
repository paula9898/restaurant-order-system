package pl.paulina.restaurant;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private int quantity;
    private Dish dish;
    private Order order;

    public OrderItem(Order order, Dish dish) {
        this.quantity = quantity;
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Dish{ "  +  dish.getName() + "}";
    }
}
