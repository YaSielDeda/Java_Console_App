package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T> {
    void add(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
    void update(T object) throws SQLException;
    void delete(T object) throws SQLException;
}