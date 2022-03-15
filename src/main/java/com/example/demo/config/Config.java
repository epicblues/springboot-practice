package com.example.demo.config;

import com.example.demo.annotation.CustomClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


@Component("config")
public class Config {
    private final Map<String, String> configFile;

    @Autowired()
    private CustomClass ccc;





    public Config() throws IOException {

        this.configFile = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(new ClassPathResource("./secret.properties").getFile())

        );
        br.lines().forEach(line -> {
            int firstEqual = line.indexOf("=");
            String tempKey = line.substring(0, firstEqual).trim();
            String tempValue = line.substring(firstEqual + 1).trim();
            if (tempValue.charAt(0) == '"' && tempValue.charAt(tempValue.length() - 1) == '"')
                tempValue = tempValue.substring(1, tempValue.length() - 1);


            configFile.put(tempKey, tempValue);

        });


    }


    public String getDbUser() {
        return configFile.get("name");
    }

    public String getDbPassword() {
        return configFile.get("password");
    }

    public String getCustomClass() {return this.ccc.myData;}
}
