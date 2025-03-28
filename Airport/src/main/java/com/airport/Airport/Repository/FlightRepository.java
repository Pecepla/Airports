package com.airport.Airport.Repository;


import com.airport.Airport.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureAirportCode(String airportCode);


    List<Flight> findByArrivalAirportCode(String airportCode);


    Flight findByFlightNumber(String flightNumber);
/*
  problemas con el Date Time
    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);
*/

}
