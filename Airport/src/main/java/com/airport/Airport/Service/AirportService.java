package com.airport.Airport.Service;

import com.airport.Airport.Model.Airport;
import com.airport.Airport.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllPAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteAirport (Long id) {
       airportRepository.deleteById(id);
    }

    public void deleteAllAirport() {
        airportRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return airportRepository.existsById(id);
    }

}
