package com.lengqi.aop.util.comsume;

public class Comsume implements Runnable {
    private Storage storage;
    public Comsume(){}
    public Comsume(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            storage.comsume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
