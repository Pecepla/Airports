package com.airport.Airport.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String passportNumber; // Fixed naming convention
    private String nationality; // Fixed naming convention
    private Date age;
    private String contactNumber;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reserve> reservations; // Added relationship

    public Passenger() {}

    public Passenger(Long id, String name, String lastname, String passportNumber, String nationality, Date age, String contactNumber, List<Reserve> reservations) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.age = age;
        this.contactNumber = contactNumber;
        this.reservations = reservations;
    }

    // Getters and setters for all fields (including reservations)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Reserve> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reserve> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(lastname, passenger.lastname) &&
                Objects.equals(passportNumber, passenger.passportNumber) &&
                Objects.equals(nationality, passenger.nationality) &&
                Objects.equals(age, passenger.age) &&
                Objects.equals(contactNumber, passenger.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, passportNumber, nationality, age, contactNumber);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", passportNumber=" + passportNumber +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
