
package javafxapplication5.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TravelInfo")
public class TravelInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTravelInfo")
    private int id;
    
    @Column(name = "Status")
    private String status;
    
    @Column(name = "TravelLength")
    private float travelLength;
    
    @Column(name = "DaysExpected")
    private int daysExpected;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DriverID",nullable = true)
    private Driver driver;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "StartCity",nullable = true)
    private City startCity;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "StopCity",nullable = true)
    private City stopCity;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CarID")
    private Car car;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTravelLength() {
        return travelLength;
    }

    public void setTravelLength(float travelLength) {
        this.travelLength = travelLength;
    }

    public int getDaysExpected() {
        return daysExpected;
    }

    public void setDaysExpected(int daysExpected) {
        this.daysExpected = daysExpected;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getStopCity() {
        return stopCity;
    }

    public void setStopCity(City stopCity) {
        this.stopCity = stopCity;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return  "Id=" + id + ", Status=" + status + ", Driver=" + driver;
    }

    public TravelInfo(String status, float travelLength, int daysExpected, Driver driver, City startCity, City stopCity, Car car) {
        this.status = status;
        this.travelLength = travelLength;
        this.daysExpected = daysExpected;
        this.driver = driver;
        this.startCity = startCity;
        this.stopCity = stopCity;
        this.car = car;
    }

    public TravelInfo() {}
 
    
    
    
}
