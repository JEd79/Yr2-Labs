public class TestMainExampleThree {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();

        Thread t2 = new Thread(()->{
            for(int i =0; i < 100000; i++) {
                c1.increment();
            }
        });

        Thread t3 = new Thread(()->{
            for(int i =0; i < 100000; i++) {
                c1.increment();
            }
        });

        t2.start();
        t3.start();

        t2.join();
        t3.join();

        System.out.println(c1.getCount());


    }
}
