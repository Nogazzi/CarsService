package pl.edu.uksw.CarsService.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nogaz on 13.07.2017.
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "producer")
    private String producer;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "engine_capacity")
    private int engineCapacity;

    @Column(name = "type")
    private String carType;

    public Car(){

    }

    public Car(String producer, String model, int productionYear, int engineCapacity, String carType) {
        this.producer = producer;
        this.model = model;
        this.productionYear = productionYear;
        this.engineCapacity = engineCapacity;
        this.carType = carType;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car[" + model + " " + producer + ", " + productionYear + ", " + engineCapacity + "cm3, " + carType + "]";
    }


    public enum CarType {
        HATCHBACK("Hatchback"),
        SEDAN("Sedan"),
        KOMBI("Kombi"),
        VAN("Van"),
        KABRIOLET("Kabriolet"),
        COUPE("Coupe"),
        PICKUP("Pickup"),
        TERENOWY("Terenowy"),
        SUV("SUV");

        private String carType;

        CarType(String carType) {
            this.carType = carType;
        }

        String getCarType(){
            return this.carType;
        }
    }

}
