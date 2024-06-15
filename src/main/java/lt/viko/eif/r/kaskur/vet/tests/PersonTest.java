package lt.viko.eif.r.kaskur.vet.tests;

import lt.viko.eif.r.kaskur.vet.model.Person;
import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Vet;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Animal animal1 = new Animal(1, "Rex", "Male", "Dog", new Vet(101, "Jane", "Smith", "Exotic Animals"));
        Animal animal2 = new Animal(2, "Mittens", "Female", "Cat", new Vet(102, "Emma", "Jones", "Feline Specialist"));

        Person person = new Person(1, "John Doe", 30, 5.9f, true, 'J', Arrays.asList(animal1, animal2));

        assertEquals(1, person.getId());
        assertEquals("John Doe", person.getName());
        assertEquals(30, person.getAge());
        assertEquals(5.9f, person.getHeight(), 0.0);
        assertTrue(person.isMarried());
        assertEquals('J', person.getInitial());
        assertEquals(2, person.getAnimals().size());
    }
}
