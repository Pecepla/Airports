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
    private Integer PassportNumber;
    private String Nationality;
    private Integer age;
    private String contactNumber;

    @OneToMany(mappedBy = "passengers", cascade = CascadeType.ALL)
    private List<Reserve> reserve;


    public Passenger(int id, String name, String lastname, Integer passportNumber, String nationality, Integer age, String contactNumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        PassportNumber = passportNumber;
        Nationality = nationality;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public Passenger() {

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id && Objects.equals(name, passenger.name) && Objects.equals(lastname, passenger.lastname) && Objects.equals(PassportNumber, passenger.PassportNumber) && Objects.equals(Nationality, passenger.Nationality) && Objects.equals(age, passenger.age) && Objects.equals(contactNumber, passenger.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, PassportNumber, Nationality, age, contactNumber);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", PassportNumber=" + PassportNumber +
                ", Nationality='" + Nationality + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}