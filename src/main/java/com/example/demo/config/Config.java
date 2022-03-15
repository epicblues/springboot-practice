package com.example.demo.config;

import com.example.demo.annotation.CustomClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


@Component("config")
public class Config {

  private final Map<String, String> configFile;

  @Autowired()
  private CustomClass ccc;

  public Config() throws IOException {

    this.configFile = new HashMap<>();

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            // getFile()로 할 경우 개발 환경에서는 성공하지만 빌드된 환경에서는 성공하지 않는다.
            // build 된 파일은 jar로 되어 있기 때문에 해당 class와 여러 파일들이 파일 시스템에 존재하는 것이 아니다.
            // 즉 한 파일로 묶여 있기 때문에 파일 시스템에서는 이 파일들을 같은 것으로 인정하는 것
            new ClassPathResource("application-secret.properties").getInputStream())
    );
    br.lines().forEach(line -> {
      int firstEqual = line.indexOf("=");
      String tempKey = line.substring(0, firstEqual).trim();
      String tempValue = line.substring(firstEqual + 1).trim();
      if (tempValue.charAt(0) == '"' && tempValue.charAt(tempValue.length() - 1) == '"') {
        tempValue = tempValue.substring(1, tempValue.length() - 1);
      }

      configFile.put(tempKey, tempValue);

    });


  }


  public String getDbUser() {
    return configFile.get("name");
  }

  public String getDbPassword() {
    return configFile.get("password");
  }

  public String getCustomClass() {
    return this.ccc.myData;
  }
}
