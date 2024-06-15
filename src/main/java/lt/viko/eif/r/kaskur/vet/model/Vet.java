package lt.viko.eif.r.kaskur.vet.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vet")
@XmlType(propOrder = {"id", "name", "lastname", "specialization"})
public class Vet {

    private int id;
    private String name;
    private String lastname;
    private String specialization;

    // Default constructor
    public Vet() {}

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

