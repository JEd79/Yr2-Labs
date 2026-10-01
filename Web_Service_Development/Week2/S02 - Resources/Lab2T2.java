public class Lab2T2 {
    public static void main(String[] args) throws InterruptedException {
        SumOfSquaresRunnable task1 = new SumOfSquaresRunnable(1,10);
        SumOfSquaresRunnable task2 = new SumOfSquaresRunnable(11,20);

        Thread th1 = new Thread(task1);
        Thread th2 = new Thread(task2);


        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Thread 1 result: " + task1.getResult());
        System.out.println("Thread 2 result: " + task2.getResult());




    }
}
