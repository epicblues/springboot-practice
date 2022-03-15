package com.example.demo;

import com.example.demo.annotation.CustomClass;
import com.example.demo.annotation.MyAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


// ComponentScan을 통해 Component가 아니더라도 나만의 annotation선언을 bean으로 추가할 수 있다.
@SpringBootConfiguration()
@EnableAutoConfiguration()
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyAnnotation.class)})
public class DemoApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(DemoApplication.class, args);
    }



}
