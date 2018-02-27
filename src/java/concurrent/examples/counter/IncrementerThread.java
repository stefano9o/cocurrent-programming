package java.concurrent.examples.counter;
import java.util.concurrent.ThreadLocalRandom;

public class IncrementerThread implements Runnable{
    private final MyInteger counter;

    IncrementerThread(MyInteger counter){
        this.counter = counter;
    }

    @Override
    public void run() {
            System.out.println("Hello world, my name is " + Thread.currentThread().getName());
            while (true) {
                int randomNum = ThreadLocalRandom.current().nextInt(1000, 4000);

                try {
                    Thread.sleep(randomNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                counter.increment();
                System.out.println(Thread.currentThread().getName() + ": counter=" + counter.toString());
            }
    }

}
