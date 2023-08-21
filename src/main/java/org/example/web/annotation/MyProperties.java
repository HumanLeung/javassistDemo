package org.example.web.annotation;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/21  15:56
 *@description:
 */
import java.lang.annotation.*;

/**
 * @author 梁晓明
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyProperties {
    String value();
    String[] names() default {};
}
