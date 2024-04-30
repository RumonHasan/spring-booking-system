package com.example.hotelManagement.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.hotelManagement.model.Room;
import com.example.hotelManagement.response.RoomResponse;
import com.example.hotelManagement.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class RoomController {

    private final IRoomService roomService;
    
    // adding new room
    public ResponseEntity<RoomResponse> addNewRoom(
        @RequestParam("photo") MultipartFile photo, 
        @RequestParam("roomType") String roomType, 
        @RequestParam("roomPrice") BigDecimal roomPrice){
        // getting the response back as a room
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), 
        savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }
}
