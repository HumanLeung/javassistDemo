package org.example.web.reflect;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/21  17:02
 *@description:
 */

import org.example.web.annotation.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 梁晓明
 */
public class AnnotationTest {
    public static void main(String[] args) {
     Class<?> clazz = MyClass.class;
     Class<? extends Annotation> annotationClass = MyAnnotation.class;
     MyAnnotation annotation = annotationClass.getAnnotation(MyAnnotation.class);
     clazz = addAnnotation(clazz,annotation);
     printAnnotations(clazz);
    }

    private static Class<?> addAnnotation(Class<?> clazz,MyAnnotation annotation){
      try{
          Field field = Class.class.getDeclaredField("annotations");
          field.setAccessible(true);
          Annotation[] annotations = (Annotation[]) field.get(clazz);
          Annotation[] newAnnotations = new Annotation[annotations.length + 1];
          System.arraycopy(annotations,0,newAnnotations,0,annotations.length);
          newAnnotations[annotations.length] = annotation;
          field.set(clazz,newAnnotations);
      }catch (Exception e){
          e.printStackTrace();
      }
      return clazz;
    }

    private static void printAnnotations(Class<?> clazz){
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }
}
