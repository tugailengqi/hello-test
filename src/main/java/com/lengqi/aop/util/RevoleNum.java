package com.lengqi.aop.util;

public class RevoleNum {
        public static final int NUM = 180;

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int k = 2;
            int num = NUM;
            System.out.print(num + "=");
            while (num > k) {
                if (num % k == 0) {
                    System.out.print(k + "*");
                    num = num / k;
                } else {
                    k++;
                }
            }
            System.out.println(k);
        }
}
