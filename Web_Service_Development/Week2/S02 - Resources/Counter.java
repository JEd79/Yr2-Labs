public class Counter {
    
    private int count;

    //public void increment() { //original without synchronized
    public synchronized void increment() { //synchronized keyword on the method in an object says in order for you to call this method, you have to have the lock
        count++;//This is 3 operations - read value of count, add 1 to value of count and then write the new value back to count
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }

    public void resetCount() {
        count = 0;
    }
}
