package com.airport.Airport.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "passenger_id") // Foreign key column for Passenger
    private Passenger passenger;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "flight_id") // Foreign key column for Flight
    private Flight flight; // Changed to reference Flight entity directly

    private Boolean estate;

    public Reserve() {}

    public Reserve(Long id, Passenger passenger, Flight flight, Boolean estate) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight; // Updated relationship with Flight entity
        this.estate = estate;
    }

    // Getters and setters for all fields
    public Long getReserveCode() {
        return id;
    }

    public void setReserveCode(Long id) {
        this.id = id;
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
        return id == reserve.id &&
                Objects.equals(passenger, reserve.passenger) &&
                Objects.equals(flight, reserve.flight) && // Updated equality check for Flight entity
                Objects.equals(estate, reserve.estate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passenger, flight, estate); // Updated hash code for Flight entity
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveCode=" + id +
                ", passenger=" + passenger +
                ", flight=" + flight + // Updated to include Flight entity in toString()
                ", estate=" + estate +
                '}';
    }
}
