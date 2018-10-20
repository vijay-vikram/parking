package com.lot.parking;

import com.google.inject.Inject;
import com.lot.parking.services.ParkingLotService;

import java.sql.SQLException;

public class CommandsParser {

  private ParkingLotService parkingLotService;

  //factory design pattern.
  //

  @Inject
  public CommandsParser(ParkingLotService parkingLotService) {
    this.parkingLotService = parkingLotService;
  }

  public void parse(String commands) throws SQLException {
//
//    StringTokenizer commandsTokenizer = new StringTokenizer(commands ,"\n");
//    Injector injector = Guice.createInjector(new ParkingLotModule());
//
//    while (commandsTokenizer.hasMoreTokens()){
//
//      String[] command = commandsTokenizer.nextToken().split(" ");
//
//      if(command[0].startsWith("create_parking_lot")){
//        injector.getInstance(ParkingLotService.class)
//            .createParkingSpace(Integer.parseInt(command[1]));
//
//      }else if(command[0].startsWith("park")){
//        injector.getInstance(ParkingAllocationService.class)
//            .allocateParkingSpace(command[1], command[2]);
//      }

//    }
  }
}
