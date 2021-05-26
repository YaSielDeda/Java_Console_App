package dao;

import entities.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository implements dao.GenericRepository<Shop> {

    private final SessionFactory factory;

    public ShopRepository(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void add(final Shop shop) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            int id = (Integer) session.createSQLQuery("SELECT MAX(ID) FROM Shops").uniqueResult();
            shop.setID(id + 1);
            session.save(shop);
            session.getTransaction().commit();
        }
    }

    @Override
    public List getAll() throws SQLException {
        try(final Session session = factory.openSession()){
            return session.createCriteria(Shop.class).list();
        }catch (Exception e){
            return new ArrayList();
        }
    }

    @Override
    public Shop getById(int id) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            Shop shop = session.get(Shop.class, id);
            session.getTransaction().commit();
            return shop;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void update(Shop shop) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(shop);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Shop shop) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(shop);
            session.getTransaction().commit();
        }
    }
}
