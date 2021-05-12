package com.lengqi.aop.util;

public class Demp {

}
class C {
    private static int numA;
    private int numA2;

    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }

    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }

    public C() {
        System.out.println("A的构造器");
    }
}

class D extends C {
    private static int numB;
    private int numB2;

    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }

    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }

    public D() {
        System.out.println("B的构造器");
    }
    public static void main(String[] args) {
        int a = 0;
        int c = 0;
        do {
            --c;
            a = a - 1;
        }while (a>0);
        System.out.println(c);
    }
}