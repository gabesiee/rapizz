package controller;


import dao.ClientDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Main extends Application {
    static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stg = primaryStage;
        primaryStage.show();
        primaryStage.setTitle("RAPIZZ");

        InputStream iconStream = getClass().getResourceAsStream("../logo.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScene.fxml"));
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, SQLException {
        Application.launch(args);

    }

    public void menuScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/menuScene.fxml"));
            Main.stg.setScene(new Scene(root));
            Main.stg.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clientsScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/clientsScene.fxml"));
            Main.stg.setScene(new Scene(root));
            Main.stg.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordersScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ordersScene.fxml"));
            Main.stg.setScene(new Scene(root));
            Main.stg.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delivMenScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/delivMenScene.fxml"));
            Main.stg.setScene(new Scene(root));
            Main.stg.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vehicScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/vehicScene.fxml"));
            Main.stg.setScene(new Scene(root));
            Main.stg.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}