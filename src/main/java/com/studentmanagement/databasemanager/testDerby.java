package com.studentmanagement.databasemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class testDerby {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private DataSource dataSource;

  public testDerby(DataSource dataSource) throws Exception {
    try {
    	this.dataSource=dataSource;
    	connect=dataSource.getConnection();
        PreparedStatement statement = connect
        .prepareStatement("SELECT * from pappu");

      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        System.out.println(resultSet.getString(1));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }



} 
