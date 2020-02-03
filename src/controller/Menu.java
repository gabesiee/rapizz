package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;
import model.Pizza;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @FXML
    private TableView<Pizza> tableView;
    @FXML
    private TableColumn<Pizza, String> pizzaColumn;
    @FXML
    private TableColumn<Pizza, String> ingreColumn;
    @FXML
    private TableColumn<Pizza, Integer> priceColumn;

    public void returnMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        Main.stg.setScene(new Scene(root));

        Main.stg.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaColumn.setCellValueFactory(new PropertyValueFactory<>("pizzaName"));
        ingreColumn.setCellValueFactory(new PropertyValueFactory<>("ingreName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("basePrice"));

        Pizza pizza = new Pizza();
        ArrayList<Pizza> pizzas = null;
        try {
            pizzas = pizza.getAll();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Pizza> piz = FXCollections.observableArrayList(pizzas);

        tableView.setItems(piz);
    }
}
