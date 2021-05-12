package com.lengqi.aop.util;


import java.util.*;

public class Test {

    public static void main(String[] args) {
        Integer i01 = 17;
        int i02 = 17;
        Integer i03 = Integer.valueOf(17);
        Integer i04 = new Integer(17);
        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);
        System.out.println(i02==i04);
    }
}
