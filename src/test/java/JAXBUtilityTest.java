import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Person;
import lt.viko.eif.r.kaskur.vet.model.Vet;
import lt.viko.eif.r.kaskur.vet.util.JAXBUtility;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Unit test for the JAXBUtility class.
 */
public class JAXBUtilityTest {

    @Test
    public void testMarshalAndUnmarshal() throws Exception {
        Vet vet1 = new Vet(101, "Jane", "Smith", "Exotic Animals");
        Vet vet2 = new Vet(102, "Emma", "Jones", "Feline Specialist");

        Animal animal1 = new Animal(1, "Rex", "Male", "Dog", vet1);
        Animal animal2 = new Animal(2, "Mittens", "Female", "Cat", vet2);

        Person person = new Person(1, "John Doe", 30, 5.9f, true, 'J', Arrays.asList(animal1, animal2));

        File file = new File("test_person.xml");

        // Test marshalling
        JAXBUtility.transformToXML(person, file);
        assertTrue(file.exists());

        // Test unmarshalling
        Person unmarshalledPerson = JAXBUtility.transformToPOJO(Person.class, file);
        assertNotNull(unmarshalledPerson);
        assertEquals(person.getId(), unmarshalledPerson.getId());
        assertEquals(person.getName(), unmarshalledPerson.getName());
        assertEquals(person.getAge(), unmarshalledPerson.getAge());
        assertEquals(person.getHeight(), unmarshalledPerson.getHeight(), 0.0);
        assertEquals(person.isMarried(), unmarshalledPerson.isMarried());
        assertEquals(person.getInitial(), unmarshalledPerson.getInitial());
        assertEquals(person.getAnimals().size(), unmarshalledPerson.getAnimals().size());

        // Cleanup
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testMarshalToConsole() throws Exception {
        Vet vet1 = new Vet(101, "Jane", "Smith", "Exotic Animals");
        Vet vet2 = new Vet(102, "Emma", "Jones", "Feline Specialist");

        Animal animal1 = new Animal(1, "Rex", "Male", "Dog", vet1);
        Animal animal2 = new Animal(2, "Mittens", "Female", "Cat", vet2);

        Person person = new Person(1, "John Doe", 30, 5.9f, true, 'J', Arrays.asList(animal1, animal2));

        // Test marshalling to console
        JAXBUtility.marshalToConsole(person);
    }
}
