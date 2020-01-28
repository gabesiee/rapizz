package dao;

import model.Client;

import java.util.List;

public interface ClientDAO {
    public List<Client> getAllClients();

    public Client getClient(int clientID);

    public void addClient(Client client);

    public void updateClient(Client client);

    public void deleteClient(Client client);
}
