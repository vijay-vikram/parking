package com.lot.parking.repositories;

import com.google.inject.Inject;
import com.lot.parking.DataBaseManager;
import com.lot.parking.models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class ParkingRepository {

  private DataBaseManager dataBaseManager;

  @Inject
  public ParkingRepository(DataBaseManager dataBaseManager) {
    this.dataBaseManager = dataBaseManager;
  }

  public void createParkingSpace(int capacity) throws SQLException {
    Statement statement = dataBaseManager.getStatement();

    StringBuilder query;
    for (int i = 0; i < capacity; i++) {
      query = new StringBuilder("INSERT INTO parking (is_available, slot_number) VALUES (")
          .append(true)
          .append(",").append("\'").append(i).append("\'")
          .append(")");
      statement.executeUpdate(query.toString());
    }
  }

  public void deleteParkingData() throws SQLException {
    Statement statement = dataBaseManager.getStatement();
    String query = "DELETE FROM parking";
    statement.executeUpdate(query);
  }

  public ResultSet getFirstEmptySlot() throws SQLException {
    Statement statement = dataBaseManager.getStatement();
    StringBuilder query = new StringBuilder("SELECT * FROM parking WHERE is_available = true order by id asc LIMIT 1");
    ResultSet resultSet = statement.executeQuery(query.toString());
    return resultSet;
  }

  public void parkThisVechile(Vehicle vehicle, int slotNumber, String currentDateAndTime) throws SQLException {
    Statement statement = dataBaseManager.getStatement();
    StringBuilder query = new StringBuilder("UPDATE parking SET registration_num = ");
    query.append("\'" + vehicle.getRegistrationNum() + "\'")
        .append(",")
        .append("color = ")
        .append("\'" + vehicle.getColor() + "\'")
        .append(",")
        .append("is_available = ")
        .append("\'" + false + "\'")
        .append(",")
        .append("time = ")
        .append("\'" + currentDateAndTime + "\'")
        .append("WHERE slot_number = ")
        .append("\'" + slotNumber + "\'");
    statement.executeUpdate(query.toString());
  }

  public void vacateParkingSlot(String slotNumber) throws SQLException {
    Statement statement = dataBaseManager.getStatement();
    StringBuilder query = new StringBuilder("UPDATE parking SET registration_num = ");
    query.append("\'" + "\'")
        .append(",")
        .append("color = ")
        .append("\'" + "\'")
        .append(",")
        .append("is_available = ")
        .append("\'" + true + "\'")
        .append("WHERE slot_number = ")
        .append("\'" + slotNumber + "\'");
    statement.executeUpdate(query.toString());
  }

  public ResultSet getVehicleDetails(String slotNumber) throws SQLException {
    Statement statement = dataBaseManager.getStatement();
    StringBuilder query = new StringBuilder("SELECT * FROM parking WHERE slot_number =");
    query.append("\'" + slotNumber + "\'");
    ResultSet resultSet = statement.executeQuery(query.toString());
    return resultSet;
  }
}
