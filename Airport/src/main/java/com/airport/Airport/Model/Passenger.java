package com.airport.Airport.Model;


import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;
    private Integer passportNumber; // Fixed naming convention
    private String nationality; // Fixed naming convention
    private Integer age;
    private String contactNumber;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Reserve> reservations; // Added relationship

    public Passenger() {}

    public Passenger(int id, String name, String lastname, Integer passportNumber, String nationality, Integer age, String contactNumber, List<Reserve> reservations) {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
