package com.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);

//        context.effectuerOperation();
//
//        context.setStrategy(new StrategyImp2 ());
//        context.effectuerOperation();
//
//        context.setStrategy(new StrategyImp1 ());
//        context.effectuerOperation();

        while(true){
            System.out.println("Quelle Strategy !?");
            String strategyClassName = scanner.nextLine();
            Strategy strategy = (Strategy) Class.forName("com.example. " + strategyClassName).newInstance();
            context.setStrategy(strategy);
            context.effectuerOperation();

        }
    }
}
