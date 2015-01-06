package com.example;

import com.example.base.Factory;
import com.example.base.UtilsFactory;

public class RuntimeClass {

    public static void main(String[] args) {

        //根据需求更改条件表达式 true or false

        Factory mFactory = new UtilsFactory();
        System.out.println(mFactory.createUtils(true).getClassData());


    }

}
