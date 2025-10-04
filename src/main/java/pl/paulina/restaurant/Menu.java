package pl.paulina.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Dish dish;
    private List<Dish> dishes = new ArrayList<>();

    public Menu() {
    }

    public void addNewDish(Dish dish) {
        dishes.add(dish);
    }

    public void showMenu() {
        for(int i = 0; i < dishes.size(); i++) {
            System.out.println(dishes.get(i).getName());
        }
    }
}
