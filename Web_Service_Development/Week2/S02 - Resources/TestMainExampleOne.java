public class TestMainExampleOne {
    public static void main(String[] args) throws InterruptedException {
        LectureExampleOne t = new LectureExampleOne(100);
        t.run(); //this is a common mistake
        t.start();
        t.join();
        System.out.println(t.getCount());

    }
}
