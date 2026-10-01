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

    public long getResult() {
        return result;
    }

}

