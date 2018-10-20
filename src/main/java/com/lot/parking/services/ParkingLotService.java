package com.lot.parking.services;

import com.google.inject.Inject;
import com.lot.parking.calculator.PriceCalculator;
import com.lot.parking.models.Vehicle;
import com.lot.parking.repositories.ParkingRepository;
import com.lot.parking.utils.DateUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;

public class ParkingLotService {

  private ParkingRepository parkingRepository;
  private PriceCalculator priceCalculator;
  private DateUtils dateUtils;

  @Inject
  public ParkingLotService(ParkingRepository parkingRepository,
                           DateUtils dateUtils,
                           PriceCalculator priceCalculator){
    this.dateUtils = dateUtils;
    this.parkingRepository = parkingRepository;
    this.priceCalculator = priceCalculator;
  }

  public StringBuilder createParkingSpace(int parkingCapacity) throws SQLException {
    parkingRepository.deleteParkingData();
    parkingRepository.createParkingSpace(parkingCapacity);
    return new StringBuilder("Created a parking lot with").append(parkingCapacity).append("slots");
  }

  public String park(Vehicle vehicle) throws SQLException {
    ResultSet resultSet = parkingRepository.getFirstEmptySlot();
    if(resultSet.next()){
      int slotNumber = resultSet.getInt("slot_number");
      parkingRepository.parkThisVechile(vehicle, slotNumber, dateUtils.getCurrentDateAndTime());
      return "Allocated slot number : " + slotNumber;
    }else{
      return "Sorry parking lot is full";
    }
  }

  public String leave(String slotNumber) throws SQLException, ParseException {
    ResultSet vehicleDetails = parkingRepository.getVehicleDetails(slotNumber);
    if (vehicleDetails.next()) {
      Timestamp vehicleParkTime = vehicleDetails.getTimestamp("time");
      long totalPrice = priceCalculator.calculate(vehicleParkTime);
      parkingRepository.vacateParkingSlot(slotNumber);
       return "Total price for slot " + slotNumber + " is " +totalPrice;
    }

    return "This Slot is already empty";
  }
}
