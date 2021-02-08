 
package javafxapplication5.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCar")
    private int id;
    
    @Column(name = "CarType")
    private String carType;
    
    @Column(name = "Brand")
    private String brand;
    
    @Column(name = "YearOfMaking")
    private int yearOfMaking;
    
    @Column(name = "Mileage")
    private int mileage;
    
    @Column(name = "CarReserved")
    private boolean carReserved;

    public Car(String carType, String brand, int yearOfMaking, int mileage, boolean carReserved) {
        this.carType = carType;
        this.brand = brand;
        this.yearOfMaking = yearOfMaking;
        this.mileage = mileage;
        this.carReserved = carReserved;
    }

    public Car() {}

      
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfMaking() {
        return yearOfMaking;
    }

    public void setYearOfMaking(int yearOfMaking) {
        this.yearOfMaking = yearOfMaking;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isCarReserved() {
        return carReserved;
    }

    public void setCarReserved(boolean carReserved) {
        this.carReserved = carReserved;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", carType=" + carType + ", brand=" + brand + ", yearOfMaking=" + yearOfMaking + ", mileage=" + mileage + ", carReserved=" + carReserved + '}';
    }
    
}
