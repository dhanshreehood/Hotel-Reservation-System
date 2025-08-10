package com.sb21java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb21java.model.Hotel;
import com.sb21java.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepo;
	
 	//add hotel details
 	public Hotel addHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

 	//get all Hotel details
	public List<Hotel> getAllHotelDetails() {
		return hotelRepo.findAll();
	}

	// get hotel details by id
	public Hotel getHotelById(int id) {
		return hotelRepo.findById(id).orElse(null);
	}
 
	//delete Hotel by id
	public void deleteById(int id)
	{
		hotelRepo.deleteById(id);
	}
	
	//update Hotel details by id
	public Hotel updateHotelById(int id, Hotel hotel)
	{
		Hotel hotelBean = hotelRepo.findById(id).get();
			if(hotel.getName()!=null)
				hotelBean.setName(hotel.getName());;
		
			if(hotel.getCity()!=null)
				hotelBean.setCity(hotel.getCity());
			
			if (hotel.getAvailableRooms() != 0) 
			    hotelBean.setAvailableRooms(hotel.getAvailableRooms());
			
			if(hotel.getPricePerNight()!=0)
				hotelBean.setPricePerNight(hotel.getPricePerNight());
			
			if(hotel.getDescription()!=null)
				hotelBean.setDescription(hotel.getDescription());
				
		return hotelRepo.save(hotelBean);
	}
}