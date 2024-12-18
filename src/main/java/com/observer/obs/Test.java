package com.observer.obs;

public class Test {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        observable.setState(90);
        observable.setState(30);
        Observer observer1 = new ObserverImpl1();
        observable.subscribe(observer1);
        observable.subscribe(new ObserverImpl2());
        observable.setState(70);
        observable.setState(50);
        observable.setState(60);
        observable.unsubscribe(observer1);
        System.out.println("\n" + "---------------END STEP1----------------" + "\n");
        observable.setState(44);
        observable.setState(34);

        observable.subscribe(new Observer() {
            @Override
            public void update(int state) {
                System.out.println("==============");
                System.out.println("Prevision = " + Math.cos(state*2.66)*Math.log(state*state));
                System.out.println("==============");
            }
        });

        observable.subscribe((state) -> {
                System.out.println("##############");
                System.out.println("Tendance = " + ((state > 50) ? "Positif" : "Negatif"));
                System.out.println("##############");
            }
        );


        observable.setState(65);
        observable.setState(44);
    }
}
