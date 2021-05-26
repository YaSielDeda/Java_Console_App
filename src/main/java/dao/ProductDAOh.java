package dao;

import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOh implements GenericDAO <Product> {

    private final SessionFactory factory;

    public ProductDAOh(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void Add(Product product) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            int id = (Integer) session.createSQLQuery("SELECT MAX(ID) FROM Products").uniqueResult();
            product.setID(id + 1);
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> getAll() throws SQLException {
        try(final Session session = factory.openSession()){
            return session.createCriteria(Product.class).list();
        }catch (Exception e){
            return new ArrayList();
        }
    }

    @Override
    public Product getById(int id) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void Update(Product product) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void Delete(Product product) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
