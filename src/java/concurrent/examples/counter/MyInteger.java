package java.concurrent.examples.counter;

public class MyInteger {
    private Integer value;

    MyInteger(Integer value){
        this.value = value;
    }

    synchronized public void increment(){
        value++;
    }

    public void decrement(){
        value--;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
