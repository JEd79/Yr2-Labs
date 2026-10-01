public class Lab2T1 {
    public static void main(String[] args) throws InterruptedException{
        
        SumOfSquaresThread th1 = new SumOfSquaresThread(0,10);
        SumOfSquaresThread th2 = new SumOfSquaresThread(11, 20);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

      
        System.out.println("Thread 1 total: " + th1.getResult());
        System.out.println("Thread 2 total: " + th2.getResult());

        long sum = th1.getResult() + th2.getResult();

        System.out.println("Sum of thread 1 and thread 2: " + sum);





    }
}