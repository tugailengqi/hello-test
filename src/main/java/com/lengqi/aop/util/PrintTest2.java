package com.lengqi.aop.util;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintTest2 {
    static AtomicInteger at = new AtomicInteger(1);
    public static void main(String[] args) {
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        new Thread(()->{
            for (char c:num){
                //如果不是1就一直返回空，直到运行打印，打印完之后把原子对象变成2
                while (at.get() != 1){}
                    System.out.println(c);
                    at.set(2);
            }
        },"t1").start();

        new Thread(()->{
            for (char s : str){
                //如果不是2就一直返回空，直到运行打印，打印完之后把原子对象变成1
                while (at.get() != 2){}
                System.out.println(s);
                at.set(1);
            }
        },"t2").start();
    }
}
