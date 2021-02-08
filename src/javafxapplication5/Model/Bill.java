package javafxapplication5.Model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBill")
    private int id;

    @Column(name = "Date")
    private Date date;
    @Column(name = "Price")
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", fetch = FetchType.EAGER)
    private Collection<TravelInfo> items = new LinkedList<>();

    public Bill() {
    }

    public Bill(Date date, double price) {
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<TravelInfo> getItems() {
        return items;
    }

    public void setItems(Collection<TravelInfo> items) {
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" + "date=" + date + ", price=" + price + ", items=" + items + '}';
    }

}
