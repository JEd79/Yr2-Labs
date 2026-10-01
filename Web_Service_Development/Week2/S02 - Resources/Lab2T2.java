public class Lab2T2 {
    public static void main(String[] args) throws InterruptedException {
        SumOfSquaresRunnable task = new SumOfSquaresRunnable(1,20);

        //https://www.geeksforgeeks.org/java/runnable-interface-in-java/
        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);


        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Thread 1 result: " + task.getResult());
        System.out.println("Thread 2 result: " + task.getResult());

        /*
        multiple threads are writing to the same variable, therefore, the program 
        contains a race condition. There is a risk that the output may be incorrect 
        as both threads can update concurrently. Not thread safe as not using synchronization.
        */


    }
}
