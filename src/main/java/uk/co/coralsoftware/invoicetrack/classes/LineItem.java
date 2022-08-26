package uk.co.coralsoftware.invoicetrack.classes;

import javax.persistence.*;

@Entity
public class LineItem {
    @Id
    @GeneratedValue
    private int id;

    private double vat;

    private double quantity;

    private double price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "invoiceid", referencedColumnName = "id")
    private Invoice invoice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


   
}
