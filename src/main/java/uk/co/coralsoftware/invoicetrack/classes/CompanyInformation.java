package uk.co.coralsoftware.invoicetrack.classes;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CompanyInformation {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenantid",referencedColumnName = "id")
    private Tenant tenant;

    @OneToMany(mappedBy = "client")
    private Set<Invoice> invoices = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
