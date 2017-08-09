package org.hewei.concurrency.daemon;


import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        Deque<Event> deque = new ArrayDeque<>();
        WriteTask writeTask = new WriteTask(deque);

        for(int i=0; i<3; i++) {
            Thread thread = new Thread(writeTask);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
