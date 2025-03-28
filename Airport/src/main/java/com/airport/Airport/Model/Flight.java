package com.airport.Airport.Model;






import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private LocalDate departureTure;
    private LocalDate arrivalTime;
    private String status;
//
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    public Flight() {
    }


    public Flight(Long id, String flightNumber, LocalDate departureTure, LocalDate arrivalTime, String status, Airport departureAirport, Airport arrivalAirport, Plane plane) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureTure = departureTure;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.plane = plane;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDepartureTure() {
        return departureTure;
    }

    public void setDepartureTure(LocalDate departureTure) {
        this.departureTure = departureTure;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureTure, flight.departureTure) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(status, flight.status) && Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport) && Objects.equals(plane, flight.plane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, departureTure, arrivalTime, status, departureAirport, arrivalAirport, plane);
    }
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureTure=" + departureTure +
                ", arrivalTime=" + arrivalTime +
                ", status='" + status + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", plane=" + plane +
                '}';
    }

}
