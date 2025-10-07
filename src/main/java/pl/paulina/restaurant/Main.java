package pl.paulina.restaurant;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Dish italianPizza = new Dish("Italian Pizza", 12.23);
        Dish neapolitanPizza = new Dish("Neapolitan Pizza", 13.30);
        Dish carbonaraPasta = new Dish("Carbonara",16.00);

        Menu topoliniRestaurant = new Menu();

        topoliniRestaurant.addNewDish(italianPizza);
        topoliniRestaurant.addNewDish(neapolitanPizza);
        topoliniRestaurant.addNewDish(carbonaraPasta);

        topoliniRestaurant.showMenu();

        Client Paulina = new Client( "Paulina");
        System.out.println(Paulina);

        Order orderOne = Paulina.placeOrder(LocalDate.of(2025,9,30));
        System.out.println(orderOne.printOrderDetails());
        orderOne.addOrderItem(carbonaraPasta);
        orderOne.addOrderItem(italianPizza);

        orderOne.printOrderedItems(Paulina.getCustomerId());
        orderOne.setStatus(Status.READY);
        System.out.println(orderOne.getStatus());
        System.out.println(orderOne.printOrderDetails());
    }
}