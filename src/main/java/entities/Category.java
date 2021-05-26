package entities;

public class Category {
    public int ID;
    public String Name;

    public Category(){ }

    public Category(String name) {
        //this.ID = ID;
        Name = name;
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
}
