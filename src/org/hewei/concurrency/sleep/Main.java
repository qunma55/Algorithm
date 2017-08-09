package org.hewei.concurrency.sleep;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}