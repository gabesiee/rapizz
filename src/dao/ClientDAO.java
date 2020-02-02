package dao;

import model.Client;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends ConnectionDAO implements DAO<Client> {
    private String req;
    private Client client;
    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public Client get(int id) throws IOException, SQLException {
        ClientDAO cDAO = new ClientDAO();
        ArrayList<Client> clients = cDAO.getAll();

        for (Client c : clients) {
            if (c.getClientID() == id) {
                return (this.client = new Client(c));
            }
        }

        return null;
    }

    @Override
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

    @Override
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

    @Override
    public void update(Client client, String[] params) {

    }

    @Override
    public void delete(Client client) throws IOException, SQLException {
        req = "DELETE FROM client WHERE CLIENT_ID = ?;";

        PreparedStatement prepare = getConnection().prepareStatement(req);
        prepare.setInt(1, client.getClientID());
        prepare.execute();

        prepare.close();
    }
}
