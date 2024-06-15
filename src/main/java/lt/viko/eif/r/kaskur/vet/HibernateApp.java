package lt.viko.eif.r.kaskur.vet;

import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Owner;
import lt.viko.eif.r.kaskur.vet.model.Vet;
import lt.viko.eif.r.kaskur.vet.model.Person;
import lt.viko.eif.r.kaskur.vet.util.JAXBUtility;

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
            // Creating a sample Person object with Animals and Vets
            Vet vet1 = new Vet(101, "Jane", "Smith", "Exotic Animals");
            Vet vet2 = new Vet(102, "Emma", "Jones", "Feline Specialist");

            Animal animal1 = new Animal(1, "Rex", "Male", "Dog", vet1);
            Animal animal2 = new Animal(2, "Mittens", "Female", "Cat", vet2);

            List<Animal> animals = new ArrayList<>();
            animals.add(animal1);
            animals.add(animal2);

            Person person = new Person(1, "John Doe", 30, 5.9f, true, 'J', animals);

            // Marshalling: Convert Java object to XML
            File file = new File("person.xml");
            JAXBUtility.marshal(person, file);
            System.out.println("Marshalling complete. Check person.xml");

            // Unmarshalling: Convert XML to Java object
            Person unmarshalledPerson = JAXBUtility.unmarshal(Person.class, file);
            System.out.println("Unmarshalling complete. Person details:");
            printPersonDetails(unmarshalledPerson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
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
        }*/
    }
    private static void printPersonDetails(Person person) {
        System.out.println("Person: " + person.getName() + " (ID: " + person.getId() + ")");
        System.out.println("Age: " + person.getAge());
        System.out.println("Height: " + person.getHeight());
        System.out.println("Married: " + person.isMarried());
        System.out.println("Initial: " + person.getInitial());
        System.out.println("Animals:");
        for (Animal animal : person.getAnimals()) {
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