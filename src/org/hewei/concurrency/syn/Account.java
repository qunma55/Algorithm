package org.hewei.concurrency.syn;

class Account {

    private double balance;

    double getBalance() {
        return balance;
    }

    void setBalance(double b) {
        balance = b;
    }

    void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp += amount;
        balance = tmp;
    }

    void substractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        tmp -= amount;
        balance = tmp;
    }
}
