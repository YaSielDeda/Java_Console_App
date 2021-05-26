package entities;

import java.sql.Time;
import java.util.Date;

public class Receipt {
    public int ID;
    public Date DateOfPurchase;
    public Time TimeOfPurchase;
    public int SellerID;
    public int DiscountID;
    public int ShopID;

    public Receipt(){ }

    public Receipt(Date dateOfPurchase, Time timeOfPurchase, int sellerID, int discountID, int shopID) {
        //this.ID = ID;
        DateOfPurchase = dateOfPurchase;
        TimeOfPurchase = timeOfPurchase;
        SellerID = sellerID;
        DiscountID = discountID;
        ShopID = shopID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateOfPurchase() {
        return DateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        DateOfPurchase = dateOfPurchase;
    }

    public Time getTimeOfPurchase() {
        return TimeOfPurchase;
    }

    public void setTimeOfPurchase(Time timeOfPurchase) {
        TimeOfPurchase = timeOfPurchase;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public int getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(int discountID) {
        DiscountID = discountID;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
    }
}
