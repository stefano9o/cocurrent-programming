package java.concurrent.examples.bankaccount;

public class Account {
    private Integer balance;

    Account(Integer initBalance){
        balance = initBalance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }
}
