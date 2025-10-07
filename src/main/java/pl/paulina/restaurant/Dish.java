package pl.paulina.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private int dishNumber;
    private String name;
    private double price;
    private List<Ingredient> ingredients = new ArrayList<>();

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
