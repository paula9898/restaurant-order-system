package pl.paulina.restaurant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dish implements Serializable {
    private String name;
    private double price;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Menu menu;

    public Dish(Menu menu,String name, double price) {
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public static Dish createDish(Menu menu, String name, double price) throws Exception {

        Dish dish = new Dish(menu, name, price);
        menu.addNewDish(dish);

        return dish;
    }

    public void addIngredient(Ingredient ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
