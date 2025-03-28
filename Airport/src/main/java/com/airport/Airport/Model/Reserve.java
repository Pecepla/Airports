package com.airport.Airport.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserveCode;

   private Passenger passenger;
   private Integer flightCode;
   private Boolean estate;

    @OneToMany(mappedBy = "reseve", cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    public Reserve(int reserveCode, Passenger pasenger, Integer flightCode, Boolean estate) {
        this.reserveCode = reserveCode;
        this.passenger = pasenger;
        this.flightCode = flightCode;
        this.estate = estate;
    }

    public Reserve() {

    }

    public int getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(int reserveCode) {
        this.reserveCode = reserveCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPasenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Integer getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(Integer flightCode) {
        this.flightCode = flightCode;
    }

    public Boolean getEstate() {
        return estate;
    }

    public void setEstate(Boolean estate) {
        this.estate = estate;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveCode=" + reserveCode +
                ", passenger=" + passenger +
                ", flightCode=" + flightCode +
                ", estate=" + estate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserve reserve = (Reserve) o;
        return reserveCode == reserve.reserveCode && Objects.equals(passenger, reserve.passenger) && Objects.equals(flightCode, reserve.flightCode) && Objects.equals(estate, reserve.estate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserveCode, passenger, flightCode, estate);
    }
}
