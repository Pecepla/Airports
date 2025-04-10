package com.airport.Airport.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String manufacture;
    private String registrationNumber;
    private Integer  capacity;
    private Integer yearOfManufacture;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flights;

    public Plane() {
    }

    public Plane(Long id, String model, String manufacture, String registrationNumber, Integer capacity, Integer yearOfManufacture, List<Flight> flights) {
        this.id = id;
        this.model = model;
        this.manufacture = manufacture;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.yearOfManufacture = yearOfManufacture;
        this.flights = flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public List<Flight> getFlights() {
        return flights;
    }
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id) && Objects.equals(model, plane.model) && Objects.equals(manufacture, plane.manufacture) && Objects.equals(registrationNumber, plane.registrationNumber) && Objects.equals(capacity, plane.capacity) && Objects.equals(yearOfManufacture, plane.yearOfManufacture) && Objects.equals(flights, plane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacture, registrationNumber, capacity, yearOfManufacture, flights);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", capacity=" + capacity +
                ", yearOfManufacture=" + yearOfManufacture +
                ", flights=" + flights +
                '}';
    }
}