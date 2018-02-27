package java.concurrent.examples.bankaccount;

public class Main {
    public static void main(String[] args) {
        int initBalance = 1000;

        Account a = new Account(initBalance);
        Giulia giulia = new Giulia(a);
        Stefano stefano = new Stefano(a);

        (new Thread(stefano, "Stefano")).start();
        for (int i = 0; i < 5; i++) {
            (new Thread(giulia, "Giulia"+i)).start();
        }
    }
}
