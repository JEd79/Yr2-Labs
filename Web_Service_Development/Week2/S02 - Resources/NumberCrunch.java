import java.util.ArrayList;
import java.util.List;

public class NumberCrunch {
    
    private List<Integer> toCrunch = new ArrayList<>();
    private List<Integer> results = new ArrayList<>();
    private FilipposLock lock = new FilipposLock();

    public NumberCrunch(List<Integer> toCrunch) {
        this.toCrunch.addAll(toCrunch);
    }

    //gets called by multiple different threads
    public boolean crunch() throws InterruptedException {
        //This code in line 17 to 23 should ensure that no 2 threads can run the code at the same time
        int toProcess;
        lock.getLock();
        try {
            if(toCrunch.isEmpty()) {
                return false;
            }
            toProcess = toCrunch.get(0);
            //System.out.println("I processed " + toProcess);//to check the number be crunched from arraylist
            toCrunch.remove(0);
        } finally {
            lock.releaseLock();
        }
        //Do something with the number

        int result = toProcess * toProcess;//TODO: Make it more complicated
        
        lock.getLock();
        try {
            results.add(result);
        } finally {
            lock.releaseLock();
        }

        return true;
    }

    // public boolean hasMore() {
    //     lock.getLock();
    //     if(toCrunch.isEmpty()) {
    //         lock.releaseLock();
    //         return false;
    //     } else {
    //         lock.releaseLock();
    //         return true;
    //     }

    // }

}
