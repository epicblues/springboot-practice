package com.example.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented()
@Component()
public @interface MyAnnotation {

  // Component의 value에 들어가는 값
  // Component에 탑재된 namespace 기능을 활용할 수 있다?
  // 즉 Qualifier 선언 없이 변수명으로 중복되는 타입 문제를 해결할 수 있다.
  @AliasFor(annotation = Component.class)
  String value() default "";

}
