public class LectureExampleTwo implements Runnable {

    private int count;
    private int max;

    public LectureExampleTwo (int max) {
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