package model;

import dao.ConnectionDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.ConnectionDAO.getConnection;

public class Client {
    private int clientID;
    private String clientLastName;
    private String clientFirstName;
    private String clientAdrs;
    private float accountBalance;
    private int pizzaCounter;
    private String req;
    private ArrayList<Client> clients = new ArrayList<>();

    public Client() {

    }

    public Client(Client client) {
        this.clientID = client.getClientID();
        this.clientLastName = client.getClientLastName();
        this.clientFirstName = client.getClientFirstName();
        this.clientAdrs = client.getClientAdrs();
        this.accountBalance = client.getAccountBalance();
        this.pizzaCounter = client.getPizzaCounter();
    }

    public Client(int clientID, String clientLastName, String clientFirstName, String clientAdrs, float accountBalance, int pizzaCounter) {
        this.clientID = clientID;
        this.clientLastName = clientLastName;
        this.clientFirstName = clientFirstName;
        this.clientAdrs = clientAdrs;
        this.accountBalance = accountBalance;
        this.pizzaCounter = pizzaCounter;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientAdrs() {
        return clientAdrs;
    }

    public void setClientAdrs(String clientAdrs) {
        this.clientAdrs = clientAdrs;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getPizzaCounter() {
        return pizzaCounter;
    }

    public void setPizzaCounter(int pizzaCounter) {
        this.pizzaCounter = pizzaCounter;
    }

    public Client get(int id) throws IOException, SQLException {
        clients = this.getAll();

        for (Client c : clients) {
            if (c.getClientID() == id) {
                return (new Client(c));
            }
        }

        return null;
    }

    public ArrayList<Client> getAll() throws IOException, SQLException {
        req = "SELECT * FROM client;";

        ResultSet result = getConnection().createStatement().executeQuery(req);
        while (result.next()) {
            int id = result.getInt("CLIENT_ID");
            String lastName = result.getString("CLIENT_NOM");
            String firstName = result.getString("CLIENT_PRENOM");
            String address = result.getString("CLIENT_ADRS");
            float accountBalance = result.getFloat("MONTANT_COMPTE");
            int pizzaCounter = result.getInt("COMPTEUR_PIZZA");

            this.clients.add(new Client(id, lastName, firstName, address, accountBalance, pizzaCounter));
        }

        return clients;
    }

    public void create(Client client) throws IOException, SQLException {
        req = "INSERT INTO client (CLIENT_NOM, CLIENT_PRENOM, CLIENT_ADRS, MONTANT_COMPTE, COMPTEUR_PIZZA) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement prepare = getConnection().prepareStatement(req);
        prepare.setString(1, client.getClientLastName());
        prepare.setString(2, client.getClientFirstName());
        prepare.setString(3, client.getClientAdrs());
        prepare.setFloat(4, client.getAccountBalance());
        prepare.setInt(5, client.getPizzaCounter());
        prepare.execute();

        prepare.close();
    }

    public void update(Client client, String[] params) {

    }

    public void delete(Client client) throws IOException, SQLException {
        req = "DELETE FROM client WHERE CLIENT_ID = ?;";

        PreparedStatement prepare = getConnection().prepareStatement(req);
        prepare.setInt(1, client.getClientID());
        prepare.execute();

        prepare.close();
    }

}
