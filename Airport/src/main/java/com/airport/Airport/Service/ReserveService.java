package com.airport.Airport.Service;



import com.airport.Airport.Model.Reserve;
import com.airport.Airport.Repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public List<Reserve> getAllReserve() {
        return reserveRepository.findAll();
    }

    public Optional<Reserve> getReseveById(Long id) {
        return reserveRepository.findById(id);
    }

    public Reserve createReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    public Reserve updateReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    public void deleteReserve (Long id) {
        reserveRepository.deleteById(id);
    }

    public void deleteAllReserve() {
        reserveRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return reserveRepository.existsById(id);
    }


}
