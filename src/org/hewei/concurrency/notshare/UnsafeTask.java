package org.hewei.concurrency.notshare;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class UnsafeTask implements Runnable {

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {

        @Override
        protected Date initialValue() {
            return new Date();
        }
    };


    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
