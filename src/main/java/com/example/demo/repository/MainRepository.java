package com.example.demo.repository;

import com.example.demo.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository("mysql")
public class MainRepository implements IRepository {

    Connection conn = null;

    @Autowired()
    Config config;

    @Autowired()
    DataSource rdbDataSource;

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
