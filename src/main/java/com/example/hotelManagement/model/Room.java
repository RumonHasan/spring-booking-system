package com.example.hotelManagement.model;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;

@Entity
@Setter
@Getter
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY, cascade = CascadeType.ALL) // when room is deleteed all the booking history is also deleted
    private List<BookedRoom> bookings;

    public Room(){
        // when a new room has been added there needs a default booking empty
        this.bookings = new ArrayList<>();
    }

    // adds the bookedRoom object to the bookings list of current room object 
    public void addBooking(BookedRoom booking){
        // to make sure not to run any null pointer exception
        if(this.bookings == null){
            this.bookings = new ArrayList<>();
        }
        // setting the current room object to booking
        this.isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
        booking.setRoom(this);
        this.bookings.add(booking); // adds to the list of bookings associated with the room
    }

}
