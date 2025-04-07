package com.airport.Airport.Repository;

import com.airport.Airport.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {


    List<Airport> findByCountry(String country);

    // Find airports by city
    List<Airport> findByCity(String city);

    // Find airport by code
    Airport findByCode(String code);
}
