package org.hewei.concurrency.syn;

class Company implements Runnable {

    private Account account;

    Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            account.addAmount(1000);
        }
    }
}
