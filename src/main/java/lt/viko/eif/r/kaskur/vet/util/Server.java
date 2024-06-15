package lt.viko.eif.r.kaskur.vet.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;

        try {
            // Create a server socket listening on the specified port
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            // Wait for a connection from a client
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a PrintWriter to send the XML file content
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the XML file and send its content to the client
            File xmlFile = new File("C:\\Users\\Robertas\\Desktop\\saitynas\\Pirmas darbas\\animals\\src\\main\\java\\lt\\viko\\eif\\r\\kaskur\\vet\\owner.xml");
            BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

            // Close the reader
            reader.close();
            System.out.println("XML file sent to client.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

