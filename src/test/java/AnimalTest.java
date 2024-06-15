import lt.viko.eif.r.kaskur.vet.model.Animal;
import lt.viko.eif.r.kaskur.vet.model.Vet;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Unit test for the Animal class.
 */
public class AnimalTest {

    @Test
    public void testAnimalCreation() {
        Vet vet = new Vet(101, "Jane", "Smith", "Exotic Animals");
        Animal animal = new Animal(1, "Rex", "Male", "Dog", vet);

        assertEquals(1, animal.getId());
        assertEquals("Rex", animal.getName());
        assertEquals("Male", animal.getGender());
        assertEquals("Dog", animal.getType());
        assertNotNull(animal.getVet());
    }
}

