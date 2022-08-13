package uk.co.coralsoftware.invoicetrack.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate date;

    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client", referencedColumnName = "id")
    private CompanyInformation client;

    @OneToMany(mappedBy = "invoice")
    private List<LineItem> lineItems = new ArrayList<>();

    public CompanyInformation getClient() {
        return client;
    }



    public void setClient(CompanyInformation client) {
        this.client = client;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
