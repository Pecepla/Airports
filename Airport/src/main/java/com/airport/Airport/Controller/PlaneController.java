package com.airport.Airport.Controller;

import com.airport.Airport.Model.Airport;
import com.airport.Airport.Model.Plane;
import com.airport.Airport.Service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/planes")
@CrossOrigin( origins="*" )
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public List<Plane> getAll() {
        return planeService.getAllPlane();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id) {
        return planeService.getPlaneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.createPlane(plane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane plane) {
        return planeService.getPlaneById(id)
                .map(existingPlane -> {
                    plane.setId(id);
                    return ResponseEntity.ok(planeService.createPlane(plane));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        return planeService.getPlaneById(id)
                .map(plane -> {
                    planeService.deletePlane(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}