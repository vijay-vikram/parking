package com.lot.parking.models;

public class Vehicle {
  private String registrationNum;
  private String color;

  public Vehicle(String registrationNum, String color) {
    this.registrationNum = registrationNum;
    this.color = color;
  }

  public String getRegistrationNum() {
    return registrationNum;
  }

  public String getColor() {
    return color;
  }
}
