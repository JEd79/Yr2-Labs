public class FilipposLock {
    //When we have multiple threads coimpeting to access a shared resource, we need to stop them from doing it all at once
    //Especially when writing to a resource e.g. a variable, list, file etc we want to make sure that only one thread is doing it at a time

    private boolean taken = false;
 
    public synchronized void getLock() throws InterruptedException {
        //Check if lock is free
        //If it is free, obtain it
        //If not free wait until it is free
        while(taken) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedException();
            }
        }

        taken = true;
    
    }

    public synchronized void releaseLock() {
        //Check if lock is taken
        //If it is taken, then release it AND notify other threads
        //If it is not taken, do nothing
        if(!taken) {
            throw new IllegalStateException("The lock is not taken, but is being released.");
            //return;//TODO: throw exception
        }
        taken = false;
        notifyAll();

    }

}
