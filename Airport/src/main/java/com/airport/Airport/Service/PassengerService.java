package com.airport.Airport.Service;

import com.airport.Airport.Model.Passenger;
import com.airport.Airport.Model.Plane;
import com.airport.Airport.Repository.PassengerRepository;
import com.airport.Airport.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
       passengerRepository.deleteById(id);
    }

    public void deleteAllPassenger() {
        passengerRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return passengerRepository.existsById(id);
    }


}
