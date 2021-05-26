package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T> {
    void Add(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
    void Update(T object) throws SQLException;
    void Delete(T object) throws SQLException;
}
