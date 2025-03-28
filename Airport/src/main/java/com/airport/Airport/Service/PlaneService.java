package com.airport.Airport.Service;


import com.airport.Airport.Model.Plane;
import com.airport.Airport.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public List<Plane> getAllPlane() {
        return planeRepository.findAll();
    }

    public Optional<Plane> getPlaneById(Long id) {
        return planeRepository.findById(id);
    }

    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public Plane updatePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

    public void deleteAllPlanes() {
        planeRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return planeRepository.existsById(id);
    }



}