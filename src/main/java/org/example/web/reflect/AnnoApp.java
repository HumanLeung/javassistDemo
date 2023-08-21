package org.example.web.reflect;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/21  16:03
 *@description: 测试
 */

import org.example.web.annotation.MyProperties;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 梁晓明
 */
public class AnnoApp {
    static final Logger logger = Logger.getLogger(AnnoApp.class.getName());

    public static void main(String[] args) {
        logger.info("modified");
        for (Field field : Pairs.class.getDeclaredFields()){
            MyProperties myProperties = field.getAnnotation(MyProperties.class);
            logger.info(myProperties.value());
            logger.info(Arrays.asList(myProperties.names()).toString());
        }
        try{
            for (Field field : Pairs.class.getDeclaredFields()){
                MyProperties myProperties = field.getAnnotation(MyProperties.class);
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(myProperties);

                for (Field declaredField : invocationHandler.getClass().getDeclaredFields()){
                    logger.info(declaredField.getName());
                }
                Field values = invocationHandler.getClass().getDeclaredField("memberValues");
                values.setAccessible(true);
                Map<String,Object> memberValues = (Map<String,Object>) values.get(invocationHandler);
                memberValues.put("value","123");
                memberValues.put("names",new String[] {"Answer","Bus","King"});
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("修改后");
        for (Field field : Pairs.class.getDeclaredFields()){
            MyProperties myProperties = field.getAnnotation(MyProperties.class);
            logger.info(myProperties.value());
            logger.info(Arrays.asList(myProperties.names()).toString());
        }
    }

}
