package com.sb21java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb21java.model.Booking;
import com.sb21java.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/")
	public ResponseEntity<String> addBooking(@RequestBody Booking eventBean)
	{
		Booking bookingBean = bookingService.addBooking(eventBean);
		return new ResponseEntity<String>("Event Added Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Booking>> getAllBookingDetails()
	{
		List<Booking> bookingList = bookingService.getAllBookingDetails();
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable int id)
	{
		Booking bookingBean = bookingService.getBookingById(id);
		return new ResponseEntity<Booking>(bookingBean,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable int id)
	{
		bookingService.deleteByBookingId(id);
		return new ResponseEntity<String>("Booking Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBookingById(@PathVariable int id, @RequestBody Booking booking)
	{
		bookingService.updateBookingById(id,booking);
		return new ResponseEntity<String>("Booking Status Updated Successfully",HttpStatus.CREATED);
	}
	
}
