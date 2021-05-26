package service;

import dao.GenericRepository;
import dao.ProductRepository;
import entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements GenericService<Product> {

    public SessionFactory factory;
    GenericRepository<Product> productDAO;

    public ProductService() {
        factory = new Configuration().configure().buildSessionFactory();
        productDAO = new ProductRepository(factory);
    }

    @Override
    public void Add(Product product) throws SQLException {
        productDAO.add(product);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        for (Object p: productDAO.getAll())
            products.add((Product) p);
        return products;
    }

    @Override
    public Product getById(int id) throws SQLException {
        return productDAO.getById(id);
    }

    @Override
    public void Update(Product product) throws SQLException {
        Product updatableProduct = productDAO.getById(product.getID());
        updatableProduct.setName(product.Name);
        updatableProduct.setCategoryID(product.CategoryID);
        updatableProduct.setInStock(product.InStock);
        updatableProduct.setCost(product.Cost);
        productDAO.update(updatableProduct);
    }

    @Override
    public void Delete(Product product) throws SQLException {
        productDAO.delete(productDAO.getById(product.getID()));
    }
}
