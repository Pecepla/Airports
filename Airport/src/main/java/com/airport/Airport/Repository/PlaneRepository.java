package com.airport.Airport.Repository;



import com.airport.Airport.Model.Flight;
import com.airport.Airport.Model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    List<Flight> getPlaneById(Plane Id);

}