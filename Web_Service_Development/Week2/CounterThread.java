public class CounterThread extends Thread {
    
    private Counter counter;
    
    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public static void main(String[] args) {

        Counter counter = new Counter();
        
        for (int i = 0; i < 1000000; i++) {
            CounterThread newCounter = new CounterThread(counter);
            newCounter.start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Probably won't happen");
        }
        System.out.println(counter.get());
    }

    public void run() {
        counter.inc();
    }
}

class Counter{
    private int i = 0;
    
    public  void inc(){
        i = i + 1;
    }
    
    public int get(){
        return i;
    }
}
