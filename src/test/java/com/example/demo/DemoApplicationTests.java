package com.example.demo;

import com.example.demo.config.Config;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void ConfigurationFileTest() throws IOException {
    Config config = new Config();
    assert config.getDbUser().equals("root");

  }


}
