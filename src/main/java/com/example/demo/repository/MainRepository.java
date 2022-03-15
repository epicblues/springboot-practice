package com.example.demo.repository;

import com.example.demo.config.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MainRepository implements IRepository {

  @Autowired()
  Config config;


  @Autowired()
  DataSource rdbDataSource;
  private Connection conn = null;

  public void createConnection() {
    System.out.println(this.config.getCustomClass());

    try {

      conn = rdbDataSource.getConnection();

      ResultSet result = conn.createStatement().executeQuery("SELECT * FROM user");
      while (result.next()) {
        System.out.println(result.getString(2));
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
