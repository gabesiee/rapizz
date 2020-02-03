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
import model.Vehicule;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Vehicules implements Initializable {
    @FXML
    private TableView<Vehicule> tableView;
    @FXML
    private TableColumn<Vehicule, String> typeColumn;
    @FXML
    private TableColumn<Vehicule, String> modelColumn;
    @FXML
    private TableColumn<Vehicule, String> registrationColumn;
    @FXML
    private TableColumn<Vehicule, Integer> delivColumn;

    public void returnMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        Main.stg.setScene(new Scene(root));

        Main.stg.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        registrationColumn.setCellValueFactory(new PropertyValueFactory<>("registration"));
        delivColumn.setCellValueFactory(new PropertyValueFactory<>("delivDone"));

        Vehicule vehicule = new Vehicule();
        ArrayList<Vehicule> vehicules = null;
        try {
            vehicules = vehicule.getAll();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Vehicule> vehic = FXCollections.observableArrayList(vehicules);

        tableView.setItems(vehic);
    }
}
