package org.hewei.concurrency.syn;

public class Main {

    public static void main(String[] args) {
        // account作为锁
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Bank bank = new Bank(account);

        Thread companyThread = new Thread(company);
        Thread bankThread = new Thread(bank);

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();

            System.out.printf("Account : Final Balance: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
