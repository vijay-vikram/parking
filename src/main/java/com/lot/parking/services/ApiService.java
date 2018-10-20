package com.lot.parking.services;

import com.google.inject.Inject;
import com.lot.parking.models.Vehicle;
import spark.Route;

public class ApiService {

  @Inject
  private ParkingLotService parkingLotService;

  public Route initizeparking() {
    return (req, res)-> {
      int parkingCapacity = Integer.valueOf(req.queryParams("capacity"));
      return parkingLotService.createParkingSpace(parkingCapacity);
    };
  }

  public Route park() {
   return (req, res) -> {
      String vehicleRegNum = req.queryParams("registration_number");
      String vehicleColor = req.queryParams("color");
      Vehicle vehicle = new Vehicle(vehicleRegNum, vehicleColor);
      return parkingLotService.park(vehicle);
    };
  }

  public Route leave() {
   return (req, res) -> {
      String slotNumber = req.queryParams("slot_number");
      return parkingLotService.leave(slotNumber);
    };
  }
}
