package com.example.hotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelManagement.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
    
} 
