package lt.viko.eif.r.kaskur.vet;

import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Owner;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HibernateApp {
    public static void main(String[] args) {

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
    }
}