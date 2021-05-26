package entities;

public class Product {
    public int ID;
    public String Name;
    public int CategoryID;
    public double Cost;
    public int InStock;

    public Product(){ }

    public Product(String name, int categoryID, double cost, int inStock) {
        //this.ID = ID;
        Name = name;
        CategoryID = categoryID;
        Cost = cost;
        InStock = inStock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }
}
