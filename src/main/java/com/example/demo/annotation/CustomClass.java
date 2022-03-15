package com.example.demo.annotation;

@MyAnnotation()
public class CustomClass {

  public String myData = null;

  public CustomClass() {
    this.myData = "hello";
    System.out.println("Bean 객체 생성됨 : " + this.getClass().getName());
  }

}