package com.example.demo.controller;

import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class MainController {

    @Autowired()
    public IRepository mysql;

    @GetMapping("/")
    public Map<String, String> intro() {
        mysql.createConnection();
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("Hello","baka");
        return returnValue;
    }

}
