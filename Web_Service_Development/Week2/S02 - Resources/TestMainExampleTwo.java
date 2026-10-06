public class TestMainExampleTwo {
    
    public static void main(String[] args) throws InterruptedException {
        LectureExampleTwo toRun = new LectureExampleTwo(100);

        Thread t2 = new Thread(toRun);
        t2.start();
        t2.join();
        System.out.println(toRun.getCount());

    }
}

