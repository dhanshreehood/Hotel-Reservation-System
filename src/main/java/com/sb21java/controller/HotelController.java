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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb21java.model.Hotel;
import com.sb21java.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<String> addHotel(@RequestBody Hotel hotel)
	{
		Hotel savedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<String>("Hotel saved successfully!", HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotelDetails()
	{
		List<Hotel> hotelList = hotelService.getAllHotelDetails();
		return new ResponseEntity<List<Hotel>>(hotelList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getEventById(@PathVariable int id)
	{
		Hotel hotelBean = hotelService.getHotelById(id);
		return new ResponseEntity<Hotel>(hotelBean,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		hotelService.deleteById(id);
		return new ResponseEntity<String>("Hotel Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateHotelById(@PathVariable int id, @RequestBody Hotel hotel)
	{
		hotelService.updateHotelById(id,hotel);
		return new ResponseEntity<String>("Hotel Updated Successfully",HttpStatus.CREATED);
	}
	
	//search hotel by name and city
	@GetMapping("/search")
	public ResponseEntity<List<Hotel>> searchHotels(
	        @RequestParam(required = false) String city,
	        @RequestParam(required = false) String name) {
	    
	    List<Hotel> results = hotelService.searchHotels(city, name);
	    return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
}
