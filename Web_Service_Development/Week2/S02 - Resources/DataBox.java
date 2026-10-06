public class DataBox {
    private String message = null;

    public synchronized void putMessageInBox(String message) {
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        this.message = message;
        notifyAll();
    }

    public synchronized String getMessageInBox() {
        while (message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        String msg = message;
        message = null;
        notifyAll();
        return msg;

    }

}
