package lt.viko.eif.r.kaskur.vet.util;


import java.io.*;
import java.net.Socket;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;

        try {
            // Connect to the server
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to the server.");

            // Create a BufferedReader to receive the XML file content
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the XML file content from the server and print it
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
