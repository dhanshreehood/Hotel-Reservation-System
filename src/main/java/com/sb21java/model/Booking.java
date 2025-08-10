package com.sb21java.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
    @Column(nullable = false)
	private LocalDate checkIn;
    
    @Column(nullable = false)
	private LocalDate checkOut;

    @Column(nullable = false)
    private int rooms;

    @Column(nullable = false)
    private Double totalPrice;
    
	@Column(name="userBookingStatus")
	private String userBookingStatus = "CONFIRMED";
    
    //keeping it unidirectional rn
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserBookingStatus() {
		return userBookingStatus;
	}

	public void setUserBookingStatus(String userBookingStatus) {
		this.userBookingStatus = userBookingStatus;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", rooms="
				+ rooms + ", totalPrice=" + totalPrice + ", userBookingStatus=" + userBookingStatus + ", hotel=" + hotel
				+ ", user=" + user + "]";
	}
    
    /*
	 json data will look:-
	  {
	  "checkIn": "2025-08-15",// for localdate format
	  "checkOut": "2025-08-18",
	  "customerName": "Dhanshree Hood",
	  "roomType": "Deluxe"
	}*/
    
}
