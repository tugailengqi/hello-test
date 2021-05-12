package com.lengqi.aop.util;

import java.util.concurrent.locks.LockSupport;

public class PrintTest {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char n :
                    str) {
                System.out.println(n);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for (char c : num) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
