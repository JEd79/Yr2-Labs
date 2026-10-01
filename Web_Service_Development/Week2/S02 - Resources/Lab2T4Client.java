import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Lab2T4Client {

    public static void main(String[] args) throws IOException {

        DatagramSocket clientSocket = new DatagramSocket();

        String content = "";

        DatagramPacket sendPacket =
            new DatagramPacket(
                content.getBytes(),
                content.getBytes().length,
                InetAddress.getByName("127.0.0.1"),
                3000
            );

        clientSocket.send(sendPacket);

        System.out.println("Connection request sent");

        DatagramPacket receivePacket =
            new DatagramPacket(new byte[1024], 1024);

        clientSocket.receive(receivePacket);

        String randomNumber =
            new String(
                receivePacket.getData(),
                0,
                receivePacket.getLength()
            );

        System.out.println(
            "Random number received: "
            + randomNumber
        );

        clientSocket.close();
    }
}

