package service;

import dao.GenericRepository;
import dao.ShopRepository;
import entities.Shop;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopService implements GenericService<Shop> {

    SessionFactory factory;
    GenericRepository<Shop> shopDAO;

    public ShopService() {
        factory = new Configuration().configure().buildSessionFactory();
        shopDAO = new ShopRepository(factory);
    }

    @Override
    public void Add(Shop shop) throws SQLException {
        shopDAO.add(shop);
    }

    @Override
    public List<Shop> getAll() throws SQLException {
        List<Shop> shops = new ArrayList<>();
        for (Object s: shopDAO.getAll())
            shops.add((Shop) s);
        return shops;
    }

    @Override
    public Shop getById(int id) throws SQLException {
        return shopDAO.getById(id);
    }

    @Override
    public void Update(Shop shop) throws SQLException {
        Shop updatableShop = shopDAO.getById(shop.getID());
        updatableShop.setAddress(shop.Address);
        shopDAO.update(updatableShop);
    }

    @Override
    public void Delete(Shop shop) throws SQLException {
        shopDAO.delete(shopDAO.getById(shop.getID()));
    }
}
