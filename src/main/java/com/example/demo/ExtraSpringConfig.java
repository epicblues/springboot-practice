package com.example.demo;

import com.example.demo.config.Config;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtraSpringConfig {


  @Autowired
  public Config config;

  @Bean
  public DataSource rdbDataSource() throws ClassNotFoundException {
    // Safe TypeCasting
    // Class<? extends SuperType> Class<?>.asSubclass(Class<SuperType>)
    // 해당 타입을 특정 타입의 하위 타입으로 casting.
    // 동적으로 로딩된 클래스가 DataSource의 하위 타입인지 확인할 수 없다.
    // 실패할 경우 ClassCastException을 발생시키고 프로그램을 종료한다.
    Class<? extends DataSource> dataSourceSubType = Class
        .forName("com.mysql.cj.jdbc.MysqlDataSource")
        .asSubclass(DataSource.class);

    return DataSourceBuilder.create()
        // DataSource의 하위 타입만 매개변수로 받는다.
        .type(dataSourceSubType).url("jdbc:mysql://localhost:3306/remember_me")
        .password(config.getDbPassword())
        .username(config.getDbUser())
        .build();


  }


  @Bean
  public DataSource mockDataSource() {
    return new DataSource() {
      @Override
      public Connection getConnection() throws SQLException {
        return null;
      }

      @Override
      public Connection getConnection(String username, String password) throws SQLException {
        return null;
      }

      @Override
      public PrintWriter getLogWriter() throws SQLException {
        return null;
      }

      @Override
      public void setLogWriter(PrintWriter out) throws SQLException {

      }

      @Override
      public int getLoginTimeout() throws SQLException {
        return 0;
      }

      @Override
      public void setLoginTimeout(int seconds) throws SQLException {

      }

      @Override
      public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
      }

      @Override
      public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
      }

      @Override
      public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
      }
    };
  }
}
