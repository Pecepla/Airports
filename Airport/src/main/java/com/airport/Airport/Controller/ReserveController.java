package com.airport.Airport.Controller;


import com.airport.Airport.Model.Airport;
import com.airport.Airport.Model.Reserve;
import com.airport.Airport.Service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")

public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    public List<Reserve> getAll() {
        return reserveService.getAllReserve();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> getReserveById(@PathVariable Long id) {
        return reserveService.getReseveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Reserve createReserve(@RequestBody Reserve reserve) {
        return reserveService.createReserve(reserve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserve> updateReserve(@PathVariable Long id, @RequestBody Reserve reserve) {
        return reserveService.getReseveById(id)
                .map(existingReserve -> {
                   reserve.setReserveCode(id);
                    return ResponseEntity.ok(reserveService.createReserve(reserve));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserve(@PathVariable Long id) {
        return reserveService.getReseveById(id)
                .map(reserve -> {
                    reserveService.deleteReserve(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
