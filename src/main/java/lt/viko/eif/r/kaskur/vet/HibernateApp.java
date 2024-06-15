package lt.viko.eif.r.kaskur.vet;

import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Owner;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;
import java.net.Socket;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HibernateApp {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;

        // Create sample Owner object with animals
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1, "Rex", "Male", "Dog"));
        animals.add(new Animal(2, "Mittens", "Female", "Cat"));
        animals.add(new Animal(3, "Polly", "Female", "Parrot"));


        Owner newOwner = new Owner(1, "John", "Doe", animals);

        try {
            // Create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Owner.class);

            // Unmarshalling: Convert XML to Java object
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Owner owner = (Owner) unmarshaller.unmarshal(new File("C:\\Users\\Robertas\\Desktop\\saitynas\\Pirmas darbas\\animals\\src\\main\\java\\lt\\viko\\eif\\r\\kaskur\\vet\\owner.xml"));
            System.out.println("Owner: " + owner.getName() + " " + owner.getLastname());

            // Print animals
            for (Animal animal : owner.getAnimals()) {
                System.out.println("\tAnimal: " + animals);
            }

            // Marshalling: Convert Java object to XML
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(newOwner, new File("output.xml"));

            System.out.println("Marshaling complete. Check output.xml");

        } catch (JAXBException e) {
            e.printStackTrace();
        }

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