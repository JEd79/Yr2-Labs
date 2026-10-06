public class SumOfSquaresRunnable implements Runnable {
    private int start;
    private int end;
    private long result;

    public SumOfSquaresRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // @Override
    // public void run() {
    //     result = 0;
    //     for (int i = start; i <= end; i++) {
    //         result += i * i;
    //     }
    // }

    //Lab2T3 update
    @Override
    public synchronized void run() {
        result = 0;
        for (int i = start; i <= end; i++) {
            result += i * i;
        }
    }

    /*
    The synchronized keyword ensures only one thread at a time can execute the run() method on the shared task object.
    Without it result could be updated by multiple threads simultaneously, causing a race condition.
    Stops concurrency as the threads execute after each has finished. 
    */

    public long getResult() {
        return result;
    }

}

