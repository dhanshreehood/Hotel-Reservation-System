package com.sb21java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb21java.model.Booking;
import com.sb21java.repository.BookingRepository;

@Service
public class BookingService {
@Autowired
private BookingRepository bookingRepo;

	//add Booking
	public Booking addBooking(Booking booking) {
	return bookingRepo.save(booking);
	}

	//get all booking details
	public List<Booking> getAllBookingDetails() {
		return bookingRepo.findAll();
	}

	// get Booking by id
	public Booking getBookingById(int id) {
		return bookingRepo.findById(id).orElse(null);
	}

	//delete by id
	public void deleteByBookingId(int id)
	{
		bookingRepo.deleteById(id);
	}

	//update Booking status by id
	public Booking updateBookingById (int id, Booking booking)
	{
		Booking bookingBean = bookingRepo.findById(id).get();
		
		if(booking.getBookingId()!=0)
			bookingBean.getBookingId();
		
		if(booking.getUserBookingStatus()!=null)
			bookingBean.setUserBookingStatus(booking.getUserBookingStatus());
				
		return bookingRepo.save(bookingBean);
	}
}
