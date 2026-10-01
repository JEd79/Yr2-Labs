public class Lab2T3 {

    public static void main(String[] args) throws InterruptedException {
        SumOfSquaresRunnable task = new SumOfSquaresRunnable(1,100);

        //https://www.geeksforgeeks.org/java/runnable-interface-in-java/
        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        Thread th3 = new Thread(task);
        Thread th4 = new Thread(task);


        th1.start();
        th2.start();
        th3.start();
        th4.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();

        System.out.println("Result: " + task.getResult());

        /*
        SumOfSquaresRunnable object was shared between multiple threads and the run() method was marked 
        as synchronized. This ensures that only one thread can execute run() at a time. This provides mutual 
        exclusion and prevents race conditions on the shared result variable. 
        Therefore, the program should produce consistent results regardless of the number of threads created.
        */




    }
}

