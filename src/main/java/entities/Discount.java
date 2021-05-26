package entities;

public class Discount {
    public int ID;
    public String TypeOfDiscount;
    public int AmountOfDiscount;

    public Discount(){ }

    public Discount(int ID, String typeOfDiscount, int amountOfDiscount) {
        this.ID = ID;
        TypeOfDiscount = typeOfDiscount;
        AmountOfDiscount = amountOfDiscount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTypeOfDiscount() {
        return TypeOfDiscount;
    }

    public void setTypeOfDiscount(String typeOfDiscount) {
        TypeOfDiscount = typeOfDiscount;
    }

    public int getAmountOfDiscount() {
        return AmountOfDiscount;
    }

    public void setAmountOfDiscount(int amountOfDiscount) {
        AmountOfDiscount = amountOfDiscount;
    }
}
