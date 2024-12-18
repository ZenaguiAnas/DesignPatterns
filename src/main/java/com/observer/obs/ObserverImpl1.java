package com.observer.obs;

public class ObserverImpl1 implements Observer {
    @Override
    public void update(int state) {
        System.out.println("********** OBS 1 ************");
        System.out.println("State Value = " + state);
        System.out.println("**********************");

    }
}
