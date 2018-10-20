package com.lot.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {


  private Connection connection;

  public Statement getStatement()throws SQLException {
    return getConnection().createStatement();
  }

  private Connection getConnection()throws SQLException{
    if(connection == null){
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/parking_lot","vijay","12345");
    }
   return connection;
  }

}
