package org.hewei.concurrency.daemon;


import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

class WriteTask implements Runnable{

    private Deque<Event> deque;
    public WriteTask (Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for(int i=1; i<100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent("Thead " + Thread.currentThread().getId());

            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
