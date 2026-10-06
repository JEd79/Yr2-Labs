import java.util.List;
import java.util.ArrayList;

public class ExtraDemo {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> toCrunch = List.of(1,45,2,88,23,110,34,71,37);

        NumberCrunch cruncher = new NumberCrunch(toCrunch);
        
        Thread t1 = new Thread(()->{
            // while(cruncher.hasMore()) {
            //     cruncher.crunch();
            // }
            boolean keepRunning;
            do {
                try {
                    keepRunning = cruncher.crunch();
                    System.out.println("T1 crunched a number.");
                } catch (InterruptedException e) {
                    keepRunning = false;
                }
            } while(keepRunning);
        });

        Thread t2 = new Thread(()->{
            // while(cruncher.hasMore()) {
            //     cruncher.crunch();
            // }
            boolean keepRunning;
            do {
                try {
                    keepRunning = cruncher.crunch();
                    System.out.println("T2 crunched a number.");                    
                } catch (InterruptedException e) {
                    keepRunning = false;
                }
            } while(keepRunning);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The program has finished!");



    }
}
