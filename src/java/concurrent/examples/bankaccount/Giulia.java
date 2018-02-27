package java.concurrent.examples.bankaccount;

import java.util.concurrent.ThreadLocalRandom;

public class Giulia implements Runnable{
    final private Account account;

    Giulia(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println("My name is " + Thread.currentThread().getName() + " and I'm born for stealing money to Stefano");
            while (true) {
                int amountWithdraw = ThreadLocalRandom.current().nextInt(50, 1000);
                int waiting = ThreadLocalRandom.current().nextInt(500, 700);

                try {
                    Thread.sleep(waiting);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ": amountWithdraw=" + amountWithdraw);

                synchronized (account) {
                    while (account.getBalance() - amountWithdraw <= 0) {
                        System.out.println(Thread.currentThread().getName() + ": not enough money. Damn it!!!!");
                        try {
                            account.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    account.withdraw(amountWithdraw);
                    System.out.println(Thread.currentThread().getName() + ": balance=" + account.getBalance());
                }
            }
    }
}
