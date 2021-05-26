package service;

import dao.CategoryRepository;
import dao.GenericRepository;
import entities.Category;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements GenericService<Category> {

    SessionFactory factory;
    GenericRepository<Category> categoryDAO;

    public CategoryService() {
        factory = new Configuration().configure().buildSessionFactory();
        categoryDAO = new CategoryRepository(factory);
    }
    
    @Override
    public void Add(Category category) throws SQLException {
        categoryDAO.add(category);
    }

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        for (Object c: categoryDAO.getAll())
            categories.add((Category) c);
        return categories;
    }

    @Override
    public Category getById(int id) throws SQLException {
        return categoryDAO.getById(id);
    }

    @Override
    public void Update(Category category) throws SQLException {
        Category updatableCategory = categoryDAO.getById(category.getID());
        updatableCategory.setName(category.Name);
        categoryDAO.update(updatableCategory);
    }

    @Override
    public void Delete(Category category) throws SQLException {
        categoryDAO.delete(categoryDAO.getById(category.getID()));
    }
}
