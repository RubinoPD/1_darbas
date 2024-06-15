package lt.viko.eif.r.kaskur.vet;

import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Owner;
import lt.viko.eif.r.kaskur.vet.model.Vet;
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

        try {
            // Create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Owner.class, Animal.class, Vet.class);

            // Unmarshalling: Convert XML to Java object
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Owner owner = (Owner) unmarshaller.unmarshal(new File("C:\\Users\\Robertas\\Desktop\\saitynas\\Pirmas darbas\\animals\\src\\main\\java\\lt\\viko\\eif\\r\\kaskur\\vet\\owner.xml"));
            printOwnerDetails(owner);

            // Create sample Owner object with animals and their vets
            List<Animal> animals = new ArrayList<>();
            animals.add(new Animal(1, "Rex", "Male", "Dog", new Vet(101, "Jane", "Smith", "Exotic Animals")));
            animals.add(new Animal(2, "Mittens", "Female", "Cat", new Vet(102, "Emma", "Jones", "Feline Specialist")));
            animals.add(new Animal(3, "Polly", "Female", "Parrot", new Vet(103, "Tom", "Brown", "Avian Specialist")));

            Owner newOwner = new Owner(1, "John", "Doe", animals);

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
    private static void printOwnerDetails(Owner owner) {
        System.out.println("Owner: " + owner.getName() + " " + owner.getLastname());
        System.out.println("Animals:");
        for (Animal animal : owner.getAnimals()) {
            System.out.println("  Animal: " + animal.getName());
            System.out.println("    Type: " + animal.getType());
            System.out.println("    Gender: " + animal.getGender());
            Vet vet = animal.getVet();
            if (vet != null) {
                System.out.println("    Vet: " + vet.getName() + " " + vet.getLastname());
                System.out.println("      Specialization: " + vet.getSpecialization());
            }
        }
    }
}