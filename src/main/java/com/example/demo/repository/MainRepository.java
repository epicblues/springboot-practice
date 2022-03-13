package com.example.demo.repository;

import com.example.demo.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@Repository("mysql")
public class MainRepository implements IRepository {

    Connection conn = null;

    @Autowired()
    Config config;

    public void createConnection() {
        try {
            conn = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/remember_me?user=%s&password=%s", config.getDbUser(), config.getDbPassword()));
            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM user");
            while (result.next()) {
                System.out.println(result.getString(2));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
