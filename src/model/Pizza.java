package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.ConnectionDAO.getConnection;

public class Pizza {
    private int pizzaID;
    private String pizzaName;
    private int basePrice;
    private int ingreID;
    private String ingreName;
    private String req;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Pizza(){

	}

    public Pizza(String name, String ingre, int basePrice) {
        this.pizzaName = name;
        this.ingreName = ingre;
        this.basePrice = basePrice;
    }

    public Pizza(Pizza pizza) {
        this.pizzaID = pizza.getPizzaID();
        this.pizzaName = pizza.getPizzaName();
        this.basePrice = pizza.getBasePrice();
        this.ingreID = pizza.getIngreID();
        this.ingreName = pizza.getIngreName();
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getIngreID() {
        return ingreID;
    }

    public void setIngreID(int ingreID) {
        this.ingreID = ingreID;
    }

    public String getIngreName() {
        return ingreName;
    }

    public void setIngreName(String ingreName) {
        this.ingreName = ingreName;
    }

    public Pizza get(int id) throws IOException, SQLException {
        pizzas = this.getAll();

        for (Pizza p : pizzas) {
            if (p.getPizzaID() == id) {
                return (new Pizza(p));
            }
        }

        return null;
    }

    public ArrayList<Pizza> getAll() throws IOException, SQLException {
        req = "SELECT PIZZA_NOM AS \"Pizza\", GROUP_CONCAT(INGRE_NOM SEPARATOR ', ') AS \"Ingrédients\", " +
                "PRIX_BASE AS \"Prix de base\" FROM pizza JOIN composer USING (PIZZA_ID) JOIN ingredient USING (INGRE_ID) " +
                "GROUP BY PIZZA_NOM;";

        ResultSet result = getConnection().createStatement().executeQuery(req);
        while (result.next()) {
            String name = result.getString("Pizza");
            String ingre = result.getString("Ingrédients");
            int price = result.getInt("Prix de base");

            this.pizzas.add(new Pizza(name, ingre, price));
        }

        return pizzas;
    }
}
