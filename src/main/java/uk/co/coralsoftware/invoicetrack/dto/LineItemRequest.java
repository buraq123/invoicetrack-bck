package uk.co.coralsoftware.invoicetrack.dto;

public class LineItemRequest {

    private double vat;

    private double quantity;

    private double price;

    private String description;

    public LineItemRequest(double vat,double quantity,double price,String description) {
        this.vat = vat;
        this.quantity = quantity;
        this.price = price;
        this.description = description;

    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
