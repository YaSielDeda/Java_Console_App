package service;

import dao.SellerRepository;
import dao.GenericRepository;
import entities.Seller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerService implements GenericService<Seller> {

    SessionFactory factory;
    GenericRepository<Seller> sellerDAO;

    public SellerService() {
        factory = new Configuration().configure().buildSessionFactory();
        sellerDAO = new SellerRepository(factory);
    }
    
    @Override
    public void Add(Seller seller) throws SQLException {
        sellerDAO.add(seller);
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        for (Object s: sellerDAO.getAll())
            sellers.add((Seller) s);
        return sellers;
    }

    @Override
    public Seller getById(int id) throws SQLException {
        return sellerDAO.getById(id);
    }

    @Override
    public void Update(Seller seller) throws SQLException {
        Seller updatableSeller = sellerDAO.getById(seller.getID());
        updatableSeller.setName(seller.Name);
        sellerDAO.update(updatableSeller);
    }

    @Override
    public void Delete(Seller seller) throws SQLException {
        sellerDAO.delete(sellerDAO.getById(seller.getID()));
    }
}
