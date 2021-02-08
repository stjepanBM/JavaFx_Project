package javafxapplication5.Model;

import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDriver")
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", fetch = FetchType.EAGER)
    private Collection<TravelInfo> putniNalozi = new LinkedList<>();

    @Column(name = "DriverName")
    private String ime;

    @Column(name = "DriverSurname")
    private String prezime;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "LicenceNumber")
    private int licenceNumber;

    public Driver(String ime, String prezime, String telephone, int licenceNumber) {
        this.ime = ime;
        this.prezime = prezime;
        this.telephone = telephone;
        this.licenceNumber = licenceNumber;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @Override
    public String toString() {
        return "Driver{" + ", ime=" + ime + ", prezime=" + prezime + '}';
    }

}
