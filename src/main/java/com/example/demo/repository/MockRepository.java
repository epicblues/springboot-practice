package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository("mock")
public class MockRepository implements IRepository {

    @Override
    public void createConnection() {
        System.out.println("mocked");
    }
}
