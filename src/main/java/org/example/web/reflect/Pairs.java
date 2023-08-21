package org.example.web.reflect;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/21  15:55
 *@description:
 */

import org.example.web.annotation.MyProperties;

/**
 * @author 梁晓明
 */
public class Pairs {
    @MyProperties("John")
    private String key;

    @MyProperties(value = "Answer",names = {"Answer", "AI"})
    private String value;

    @MyProperties("B.M")
    public void generate(){

    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
