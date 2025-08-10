package com.sb21java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb21java.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
