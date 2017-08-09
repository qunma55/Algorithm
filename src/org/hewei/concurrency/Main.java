package org.hewei.concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        // 创建10个Thread实例
        Thread threads[] = new Thread[10];
        // 记录10个线程的状态
        Thread.State status[] = new Thread.State[10];

        // 设置优先级
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        for (int i=0; i<10; i++) {
            threads[i].start();
        }

        try {
            FileWriter file = new FileWriter(".\\data\\log.txt");
            PrintWriter pw = new PrintWriter(file);
            for (int i=0; i<10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            pw.flush();

            // 直到这10个线程执行结束，我们会一直检查它们的状态。如果发现它的状态改变，就把状态记入文本。
            // 这里并不会记录每一次状态的变化，而是一段时间内的变化
            boolean finish = false;
            while (!finish) {
                for (int i=0; i<10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                pw.flush();

                finish = true;
                // 当10个状态均为True，finish才为True
                for (int i=0; i<10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个方法写线程的 ID, name, priority, old status, 和 new status。
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
