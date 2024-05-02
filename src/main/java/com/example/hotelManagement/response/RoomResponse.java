package com.example.hotelManagement.response;
import java.util.*;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

// selecting the information you want to show in the frontend
public class RoomResponse {
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    private String photo;
    private List<BookingResponse> bookings;

    // for the ui
    public RoomResponse(Long id, String roomType, BigDecimal roomPrice){
        this.id = id;
        this.roomType = roomType;
        this.roomPrice =  roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes, List<BookingResponse> bookings){
        this.id = id;
        this.roomType = roomType;
        this.roomPrice =  roomPrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes): null;
        this.bookings = bookings;
    }


}
