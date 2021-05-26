package entities;

public class ReceiptPosition {
    public int ID;
    public int ReceiptID;
    public int ProductQuantity;
    public int ProductID;

    public ReceiptPosition() { }

    public ReceiptPosition(int receiptID, int productQuantity, int productID) {
        //this.ID = ID;
        ReceiptID = receiptID;
        ProductQuantity = productQuantity;
        ProductID = productID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(int receiptID) {
        ReceiptID = receiptID;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }
}
