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
import model.Order;
import model.Vehicule;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Orders implements Initializable {
    @FXML
    private TableView<Order> tableView;
    @FXML
    private TableColumn<Order, String> dateColumn;
    @FXML
    private TableColumn<Order, String> clientColumn;
    @FXML
    private TableColumn<Order, String> pizzaColumn;
    @FXML
    private TableColumn<Order, String> sizeColumn;
    @FXML
    private TableColumn<Order, String> delivColumn;
    @FXML
    private TableColumn<Order, String> vehicColumn;
    @FXML
    private TableColumn<Order, String> fidelityColumn;
    @FXML
    private TableColumn<Order, String> lateColumn;
    @FXML
    private TableColumn<Order, Float> priceColumn;

    public void returnMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        Main.stg.setScene(new Scene(root));

        Main.stg.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        pizzaColumn.setCellValueFactory(new PropertyValueFactory<>("pizzaName"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("sizeName"));
        delivColumn.setCellValueFactory(new PropertyValueFactory<>("delivMan"));
        vehicColumn.setCellValueFactory(new PropertyValueFactory<>("registration"));
        fidelityColumn.setCellValueFactory(new PropertyValueFactory<>("fidelity"));
        lateColumn.setCellValueFactory(new PropertyValueFactory<>("late"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        Order order = new Order();
        ArrayList<Order> orders = null;
        try {
            orders = order.getAll();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Order> ord = FXCollections.observableArrayList(orders);

        tableView.setItems(ord);
    }
}
