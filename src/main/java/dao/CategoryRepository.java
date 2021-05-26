package dao;

import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements GenericRepository<Category> {

    private final SessionFactory factory;

    public CategoryRepository(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void add(Category category) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            int id = (Integer) session.createSQLQuery("SELECT MAX(ID) FROM Categories").uniqueResult();
            category.setID(id + 1);
            session.save(category);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Category> getAll() throws SQLException {
        try(final Session session = factory.openSession()){
            return session.createCriteria(Category.class).list();
        }catch (Exception e){
            return new ArrayList();
        }
    }

    @Override
    public Category getById(int id) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            Category category = session.get(Category.class, id);
            session.getTransaction().commit();
            return category;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void update(Category category) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Category category) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
        }
    }
}
