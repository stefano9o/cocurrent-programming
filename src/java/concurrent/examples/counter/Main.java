package java.concurrent.examples.counter;

public class Main {
    public static void main(String[] args) {
        int nThread = 10;

        MyInteger counter = new MyInteger(100);
        IncrementerThread it = new IncrementerThread(counter);
        DecrementerThread dt = new DecrementerThread(counter);

        for (int i = 0; i < nThread; i++){
            (new Thread(dt,"Decrementer" + i)).start();
            (new Thread(it,"Incrementer" + i)).start();
        }
    }
}
