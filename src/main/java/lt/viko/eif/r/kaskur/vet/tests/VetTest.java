package lt.viko.eif.r.kaskur.vet.tests;

import lt.viko.eif.r.kaskur.vet.model.Vet;

import org.junit.Test;

import static org.junit.Assert.*;

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

