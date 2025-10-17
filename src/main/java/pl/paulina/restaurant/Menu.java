package pl.paulina.restaurant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    private List<Dish> dishes = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
