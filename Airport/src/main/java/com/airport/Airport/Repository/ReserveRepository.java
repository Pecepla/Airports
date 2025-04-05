package com.airport.Airport.Repository;

import com.airport.Airport.Model.Airport;
import com.airport.Airport.Model.Flight;
import com.airport.Airport.Model.Passenger;
import com.airport.Airport.Model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    List<Passenger> findByPassengerId(Passenger passenger);


   Flight findByFlightId(Long id);



}
