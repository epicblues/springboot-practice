package com.example.demo.annotation;


import org.springframework.beans.factory.annotation.Qualifier;

@MyAnnotation("ccc")
@Qualifier("ccc")
public class CustomClassChild extends CustomClass{

    public CustomClassChild() {

        this.myData="children";
    }

    public String getMyData() {
        this.myData = "children";
        return myData;
    }
}
