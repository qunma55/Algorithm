package org.hewei.concurrency.syn;

class Bank implements Runnable {

    private Account account;

    Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
           account.substractAmount(1000);
        }
    }
}
