package com.lengqi.aop.util.comsume;

public class Product implements Runnable {
    private Storage storage;
    public Product(){

    }
    public Product(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            storage.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
