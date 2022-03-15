package com.example.demo.annotation;


@MyAnnotation("ccc")
public class CustomClassChild extends CustomClass {

  public CustomClassChild() {

    this.myData = "children";
  }

  public String getMyData() {
    this.myData = "children";
    return myData;
  }
}
