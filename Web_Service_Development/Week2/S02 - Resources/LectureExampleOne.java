public class LectureExampleOne extends Thread {

    private int count;
    private int max;

    public LectureExampleOne (int max) {
        this.max = max;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < max; ++i) {
            count = count + i; 
        }
    }

    public int getCount() {
        return count;
    }

}