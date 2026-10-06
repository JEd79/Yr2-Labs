public class MainForDataBox {
    public static void main(String[] args) throws InterruptedException {
        DataBox d1 = new DataBox();

        Thread t4 = new Thread(()->{
            int counter = 0;
            while(true) {
                d1.putMessageInBox("Number: " + counter);
                counter++;
            }
        });

        Thread t5 = new Thread(()->{
            while(true) {
                String message = d1.getMessageInBox();
                System.out.println(message);
            }
        });

        t4.start();
        t5.start();

        t4.join();
        t5.join();

        //System.out.println(d1.getCount());


    }
}
