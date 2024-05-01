package com.example.hotelManagement.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.example.hotelManagement.model.Room;

import io.jsonwebtoken.io.IOException;

public interface IRoomService {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws SQLException, IOException, java.io.IOException;
}
