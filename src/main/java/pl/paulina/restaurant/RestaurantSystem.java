package pl.paulina.restaurant;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RestaurantSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE = "restaurant.ser";

    private List<Client> clientsList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private List<Dish>  dishList = new ArrayList<>();
    private Menu menu;

    public void addNewClient(Client client) {
        clientsList.add(client);
    }
    public void addNewOrder (Order order) {orderList.add(order);}

    public void addNewMenu(Menu menu) {
        this.menu = menu;
    };

    public String getMenu() {
        return this.menu.getName();
    }

    public void writeToFile(ObjectOutputStream out) throws IOException, ClassNotFoundException {

        out.writeObject(this);
    }

    public void save() throws FileNotFoundException {

        try (FileOutputStream f = new FileOutputStream(FILE);
             ObjectOutputStream s = new ObjectOutputStream(f)) {

            writeToFile(s);
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }
        System.out.println("Successfully saved");
    }

    public static RestaurantSystem loadFile() throws IOException, ClassNotFoundException {

        try (FileInputStream in = new FileInputStream(FILE);
             ObjectInputStream s = new ObjectInputStream(in)) {

            //Object o = s.readObject();
            RestaurantSystem loaded = (RestaurantSystem) s.readObject();
            return loaded;

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        RestaurantSystem restaurantSystem = RestaurantSystem.loadFile();

        if(restaurantSystem == null) {

            restaurantSystem = new RestaurantSystem();
        }

        Menu menuTopollino = new Menu("Menu Topollino");

        restaurantSystem.addNewMenu(menuTopollino);

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

        restaurantSystem.addNewClient(client1);

        Order orderClient1 = client1.placeOrder(LocalDate.now());
        orderClient1.addOrderItem(rucolaPizza);

        orderClient1.setStatus(OrderStatus.CANCELLED);
        System.out.println(orderClient1.getStatus());

        System.out.println(orderClient1.getOrderedItems());

        restaurantSystem.save();
    }
}
