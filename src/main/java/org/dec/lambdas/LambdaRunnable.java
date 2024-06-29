package org.dec.lambdas;

public class LambdaRunnable {
    public static void main(String[] args) {
        // Prior to Lamdas
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 running");
            }
        };

        new Thread(runnable).start();

        // With Lambdas

        Runnable runnable2 = () -> System.out.println("Thread 2 running");
        new Thread(runnable2).start();

        new Thread(()-> System.out.println("Thread 3 running")).start();
    }
}
