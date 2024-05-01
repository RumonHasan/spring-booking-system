package com.example.hotelManagement.controller;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.hotelManagement.model.Room;
import com.example.hotelManagement.response.RoomResponse;
import com.example.hotelManagement.service.IRoomService;

import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class RoomController {

    private final IRoomService roomService; // has the connection to the main function in room service
    
    // adding new room
    public ResponseEntity<RoomResponse> addNewRoomResponse(
        // data received from the front end
        @RequestParam("photo") MultipartFile photo, 
        @RequestParam("roomType") String roomType, 
        @RequestParam("roomPrice") BigDecimal roomPrice) throws IOException, SQLException, java.io.IOException{
        // getting the response back as a room after adding a new room
        Room savedRoom = this.roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), 
        savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }
}
