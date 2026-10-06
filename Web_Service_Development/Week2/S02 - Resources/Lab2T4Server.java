import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Lab2T4Server {

    public static void main(String[] args) throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(3000);

        System.out.println("Server running...");

        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);

            System.out.println("Waiting for request...");

            serverSocket.receive(receivePacket);

            System.out.println("Request received from " + receivePacket.getAddress() + ":" + receivePacket.getPort()
            );

            Lab2T4Worker worker = new Lab2T4Worker(serverSocket,receivePacket);

            worker.start();
        }
    }
}

/*
The server was modified to use multithreading. The main thread continuously listens for incoming UDP requests and creates 
a new Lab2T4Worker thread for each client request. Each worker thread is responsible for processing a single
request, generating a random number, and sending the response back to the client. 
This allows the server to handle multiple client requests concurrently while the main thread remains available
to accept new requests. More performant than the original single-threaded implementation.
*/
