package com.lot.parking;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lot.parking.services.ApiService;

import static spark.Spark.*;


public class ParkingLotApplication {




  public static void main(String args[]) {


    Injector injector = Guice.createInjector(new ParkingLotModule());
    ApiService apiService = injector.getInstance(ApiService.class);

    get("/hello", (req, res) -> "Hello World");

    put("/initialize/parking", apiService.initizeparking());

    post("/parking/park", apiService.park());

    post("/parking/leave", apiService.leave());


  }

}
