import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Lab2T4Worker extends Thread {

    private DatagramSocket socket;
    private DatagramPacket receivePacket;

    public Lab2T4Worker(DatagramSocket socket,
                              DatagramPacket receivePacket) {
        this.socket = socket;
        this.receivePacket = receivePacket;
    }

    @Override
    public void run() {

        try {
            // Get client details
            var clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Generate random number
            int randomNumber = (int)(Math.random() * 100) + 1;

            String message = String.valueOf(randomNumber);

            DatagramPacket sendPacket =
                new DatagramPacket(
                    message.getBytes(),
                    message.getBytes().length,
                    clientAddress,
                    clientPort
                );

            socket.send(sendPacket);

            System.out.println(
                getName() +
                " sent random number " +
                randomNumber +
                " to " +
                clientAddress +
                ":" +
                clientPort
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}