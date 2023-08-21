package org.example.web.annotation;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/21  17:00
 *@description: 测试
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 梁晓明
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String value();
}
