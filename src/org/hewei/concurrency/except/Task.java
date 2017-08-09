package org.hewei.concurrency.except;

public class Task implements Runnable {

    @Override
    public void run() {
        int number = Integer.parseInt("X");
    }
}
