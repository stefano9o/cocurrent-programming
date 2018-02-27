package java.concurrent.examples.bankaccount;

import java.util.concurrent.ThreadLocalRandom;

public class Stefano implements Runnable{
    final private Account account;

    Stefano(Account account){
        this.account = account;
    }

    @Override
    public void run() {
            System.out.println("My name is " + Thread.currentThread().getName() + " and I'm not lucky at all!!!");
            while (true) {
                int amountDeposit = ThreadLocalRandom.current().nextInt(2500, 3000);
                int waiting = ThreadLocalRandom.current().nextInt(2800, 3100);

                try {
                    Thread.sleep(waiting);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ": amountDeposit=" + amountDeposit);
                synchronized (account){
                    account.deposit(amountDeposit);
                    account.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ": balance=" + account.getBalance());
                }
            }
    }

}
