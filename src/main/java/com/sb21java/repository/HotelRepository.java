package com.sb21java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb21java.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    // Search by city
    List<Hotel> findByCity(String city);

    // Search by name (partial match)
    List<Hotel> findByName(String name);

    // Search by city and name
    List<Hotel> findByCity(String city, String name);
}
