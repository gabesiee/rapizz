package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T get(int id) throws IOException, SQLException;

    List<T> getAll() throws IOException, SQLException;

    void create(T t) throws IOException, SQLException;

    void update(T t, String[] params);

    void delete(T t) throws IOException, SQLException;
}
