package pl.paulina.restaurant;

public class OrderItem {
    private int quantity;
    private Dish dish;

    public OrderItem(Dish dish) {
        this.quantity = quantity;
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Dish{ "  +  dish.getName();
    }
}
