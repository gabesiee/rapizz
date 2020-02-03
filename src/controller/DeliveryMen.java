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
import model.DeliveryMan;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeliveryMen implements Initializable {
    @FXML
    private TableView<DeliveryMan> tableView;
    @FXML
    private TableColumn<DeliveryMan, String> nameColumn;
    @FXML
    private TableColumn<DeliveryMan, Integer> delivColumn;
    @FXML
    private TableColumn<DeliveryMan, Integer> lateColumn;


    public void returnMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        Main.stg.setScene(new Scene(root));

        Main.stg.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("delivManName"));
        delivColumn.setCellValueFactory(new PropertyValueFactory<>("delivDone"));
        lateColumn.setCellValueFactory(new PropertyValueFactory<>("late"));

        DeliveryMan delivMan = new DeliveryMan();
        ArrayList<DeliveryMan> deliveryMen = null;
        try {
            deliveryMen = delivMan.getAll();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList<DeliveryMan> deliv = FXCollections.observableArrayList(deliveryMen);

        tableView.setItems(deliv);
    }
}
