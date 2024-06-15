import lt.viko.eif.r.kaskur.vet.model.Vet;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Unit test for the Vet class.
 */
public class VetTest {

    @Test
    public void testVetCreation() {
        Vet vet = new Vet(101, "Jane", "Smith", "Exotic Animals");

        assertEquals(101, vet.getId());
        assertEquals("Jane", vet.getName());
        assertEquals("Smith", vet.getLastname());
        assertEquals("Exotic Animals", vet.getSpecialization());
    }
}

