public class SumOfSquaresThread extends Thread {
    private int start;
    private int end;
    private long result;

    public SumOfSquaresThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        result = 0;
        for (int i = start; i <= end; i++) {
            result += i * i;
        }
    }

    public long getResult() {
        return result;
    }
 
 }
