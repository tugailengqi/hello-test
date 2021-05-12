package com.lengqi.aop.util.comsume;

import java.util.ArrayList;
import java.util.LinkedList;

public class Storage {
    private final int MAX_SIZE  = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public void produce(){
        synchronized (list){
            while (list.size() + 1 > MAX_SIZE){
                System.out.println("【生产者"+Thread.currentThread().getName()+"】仓库已满");
                try{
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者"+Thread.currentThread().getName()+"】生产一个产品，现库存:"+list.size());
            list.notifyAll();
        }
    }
    public void comsume(){
        synchronized (list){
            while (list.size() == 0){
                System.out.println("【消费者"+Thread.currentThread().getName()+"】仓库为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者"+Thread.currentThread().getName()+"】消费一个产品，现库存："+list.size());
            list.notifyAll();
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread t1 = new Thread(new Product(storage));
        Thread t2 = new Thread(new Product(storage));
        Thread t3 = new Thread(new Product(storage));

        Thread c1 = new Thread(new Comsume(storage));
        Thread c2 = new Thread(new Comsume(storage));
        Thread c3 = new Thread(new Comsume(storage));

        t1.start();
        t2.start();
        t3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
