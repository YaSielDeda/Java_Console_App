package entities;

public class Shop {

    public int ID;
    public String Address;

    public Shop(){ }

    public Shop(String address) {
        //this.ID = ID;
        Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
