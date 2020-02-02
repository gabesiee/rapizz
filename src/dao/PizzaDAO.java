package dao;

import model.Client;
import model.Pizza;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO extends ConnectionDAO implements DAO<Pizza> {
    private String req;
    private Pizza pizza;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    @Override
    public Pizza get(int id) throws IOException, SQLException {
        return null;
    }

    @Override
    public List<Pizza> getAll() throws IOException, SQLException {
        return null;
    }

    @Override
    public void create(Pizza pizza) throws IOException, SQLException {

    }

    @Override
    public void update(Pizza pizza, String[] params) {

    }

    @Override
    public void delete(Pizza pizza) throws IOException, SQLException {

    }
}
