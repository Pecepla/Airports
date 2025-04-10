package com.airport.Airport.Controller;

import com.airport.Airport.Model.Airport;
import com.airport.Airport.Model.Passenger;
import com.airport.Airport.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/passenger")
@CrossOrigin(origins= "*" )
public class PassengerController{

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerService.getAllPassenger();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.getPassengerById(id)
                .map(existingPassenger -> {
                   passenger.setId(id);
                    return ResponseEntity.ok(passengerService.createPassenger(passenger));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        return passengerService.getPassengerById(id)
                .map(passenger -> {
                   passengerService.deletePassenger(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
