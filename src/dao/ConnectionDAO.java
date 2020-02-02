package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDAO {
    public static Connection getConnection() throws SQLException, IOException {
        FileInputStream file = new FileInputStream("src/dao/dao.properties");
        Properties props = new Properties();
        props.load(file);

        String url = props.getProperty("url");
        String login = props.getProperty("login");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, login, password);
    }
}
