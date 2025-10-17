package pl.paulina.restaurant;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Menu  menuTopollino  = new Menu("Toppolino");

        Dish rucolaPizza = new Dish(menuTopollino, "Rucola Pizza", 12.50);
        Dish mergherita = new Dish(menuTopollino, "Margherita", 9.50);
        Dish rustica = new Dish(menuTopollino, "Rustica ", 15.50);
        Dish salami = new Dish(menuTopollino, "Salami", 12.50);

        Ingredient mozarrella = new Ingredient("Mozarella");
        Ingredient rucola = new Ingredient("Rucola");
        Ingredient hardCheese = new Ingredient("Hard cheese");
        Ingredient garlic = new Ingredient("Garlic");

        rucolaPizza.addIngredient(mozarrella);
        rucolaPizza.addIngredient(rucola);
        rucolaPizza.addIngredient(hardCheese);
        rucolaPizza.addIngredient(garlic);

        menuTopollino.addNewDish(rucolaPizza);
        menuTopollino.addNewDish(mergherita);
        menuTopollino.addNewDish(rustica);
        menuTopollino.addNewDish(salami);

        System.out.println(rucolaPizza.getIngredients());

        Client client1 = new Client("Otrebska");

        Order orderClient1 = client1.placeOrder(LocalDate.now());
        orderClient1.addOrderItem(rucolaPizza);

        System.out.println(orderClient1.getStatus());
        orderClient1.setStatus(OrderStatus.CANCELLED);
        System.out.println(orderClient1.getStatus());

        System.out.println(orderClient1.getOrderedItems());

    }
}