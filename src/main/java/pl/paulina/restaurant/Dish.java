package pl.paulina.restaurant;

public class Dish {
    private int dishNumber;
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.dishNumber = dishNumber;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
