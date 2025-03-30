package com.airport.Airport.Model;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserveCode;

    @ManyToOne
    @JoinColumn(name = "passenger_id") // Foreign key column for Passenger
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id") // Foreign key column for Flight
    private Flight flight; // Changed to reference Flight entity directly

    private Boolean estate;

    public Reserve() {}

    public Reserve(int reserveCode, Passenger passenger, Flight flight, Boolean estate) {
        this.reserveCode = reserveCode;
        this.passenger = passenger;
        this.flight = flight; // Updated relationship with Flight entity
        this.estate = estate;
    }

    // Getters and setters for all fields
    public int getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(int reserveCode) {
        this.reserveCode = reserveCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight; // Updated getter for Flight entity
    }

    public void setFlight(Flight flight) { // Updated setter for Flight entity
        this.flight = flight;
    }

    public Boolean getEstate() {
        return estate;
    }

    public void setEstate(Boolean estate) {
        this.estate = estate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserve reserve = (Reserve) o;
        return reserveCode == reserve.reserveCode &&
                Objects.equals(passenger, reserve.passenger) &&
                Objects.equals(flight, reserve.flight) && // Updated equality check for Flight entity
                Objects.equals(estate, reserve.estate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserveCode, passenger, flight, estate); // Updated hash code for Flight entity
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveCode=" + reserveCode +
                ", passenger=" + passenger +
                ", flight=" + flight + // Updated to include Flight entity in toString()
                ", estate=" + estate +
                '}';
    }
}
