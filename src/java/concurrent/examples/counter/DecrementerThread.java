package java.concurrent.examples.counter;
import java.util.concurrent.ThreadLocalRandom;

public class DecrementerThread implements Runnable{
    private final MyInteger counter;

    DecrementerThread(MyInteger counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Hello world, my name is " + Thread.currentThread().getName());
            while (true) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

                try {
                    Thread.sleep(randomNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.remove();
                System.out.println(Thread.currentThread().getName() + ": counter=" + counter);
            }
        }
    }


    synchronized private void remove(){
        counter.decrement();
    }
}
