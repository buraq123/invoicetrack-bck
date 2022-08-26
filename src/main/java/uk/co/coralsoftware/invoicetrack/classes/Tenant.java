package uk.co.coralsoftware.invoicetrack.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tenant {
    @Id @GeneratedValue
    private int id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "tenant")
    private Set<CompanyInformation> clients  = new HashSet<>();

    public Tenant(){

    }

    public Set<CompanyInformation> getClients() {
        return clients;
    }

    public void setClients(Set<CompanyInformation> clients) {
        this.clients = clients;
    }

    public Tenant(String name){
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant that = (Tenant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
