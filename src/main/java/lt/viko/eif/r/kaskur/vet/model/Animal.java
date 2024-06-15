package lt.viko.eif.r.kaskur.vet.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "animal")
@XmlType(propOrder = {"id", "name", "gender", "type", "vet"})
public class Animal {

    private int id;
    private String name;
    private String gender;
    private String type;
    private Vet vet;

    // Default constructor
    public Animal() {}

    public Animal(int id, String name, String gender, String type, Vet vet) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.vet = vet;
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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String toString() {
        return String.format("\t\tName: %s\n\t" + "\t\tGender: %s\n\t" + "\t\tType: %s\n\t\n\t", this.name, this.gender, this.type);
    }
}

