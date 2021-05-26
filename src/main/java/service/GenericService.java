package service;

import java.sql.SQLException;
import java.util.List;

public interface GenericService<T>{
    void Add(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
    void Update(T object) throws SQLException;
    void Delete(T object) throws SQLException;
}
