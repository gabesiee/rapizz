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


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Clients implements Initializable {
    @FXML
    private TableView<Client> tableView;
    @FXML
    private TableColumn<Client, Integer> numberColumn;
    @FXML
    private TableColumn<Client, String> lastNameColumn;
    @FXML
    private TableColumn<Client, String> firstNameColumn;
    @FXML
    private TableColumn<Client, String> addressColumn;
    @FXML
    private TableColumn<Client, Float> accountBalanceColumn;
    @FXML
    private TableColumn<Client, Integer> pizzaCounterColumn;

    public void returnMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        Main.stg.setScene(new Scene(root));

        Main.stg.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("clientID"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientLastName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientFirstName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("clientAdrs"));
        accountBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("accountBalance"));
        pizzaCounterColumn.setCellValueFactory(new PropertyValueFactory<>("pizzaCounter"));

        Client client = new Client();
        ArrayList<Client> clients = null;
        try {
            clients = client.getAll();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Client> cli = FXCollections.observableArrayList(clients);

        tableView.setItems(cli);

    }
}
