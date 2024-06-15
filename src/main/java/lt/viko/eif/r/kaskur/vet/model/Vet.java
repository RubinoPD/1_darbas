package lt.viko.eif.r.kaskur.vet.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Represents a Vet with various attributes.
 */
@XmlRootElement(name = "vet")
@XmlType(propOrder = {"id", "name", "lastname", "specialization"})
public class Vet {

    private int id;
    private String name;
    private String lastname;
    private String specialization;

    /**
     * Default constructor.
     */
    public Vet() {}

    /**
     * Parameterized constructor.
     *
     * @param id             the ID of the vet
     * @param name           the name of the vet
     * @param lastname       the lastname of the vet
     * @param specialization the specialization of the vet
     */
    public Vet(int id, String name, String lastname, String specialization) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.specialization = specialization;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlElement
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

