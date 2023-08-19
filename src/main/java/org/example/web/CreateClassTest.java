package org.example.web;/*
 *@program:JavassistDemo
 *@author: liangxm
 *@Time: 2023/8/18  13:20
 *@description: 测试
 */

import javassist.*;

/**
 * @author 梁晓明
 */
public class CreateClassTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("org.example.entity.Person");
        StringBuffer body = null;
        CtField ctField = new CtField(classPool.get("java.lang.String"),"name",ctClass);
//        ctField.setModifiers();

    }
}
