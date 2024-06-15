package lt.viko.eif.r.kaskur.vet.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "owner")
@XmlType(propOrder = {"id", "name", "lastname", "animals"})
public class Owner {

    private int id;
    private String name;
    private String lastname;
    private List<Animal> animals;

    // Default constructor
    public Owner() {}

    public Owner(int id, String name, String lastname, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.animals = animals;
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
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    private String ConstructAnimalString() {
        String result = "";
        for (Animal animal : this.animals) {
            result += animal.toString();
        }
        return result;
    }

    public String toString() {
        return String.format("Owner:\n\tFirstName = %s\n\t" + "LastName = %s\n\t" +
                        "\tAnimals: \n\t%s\n", ConstructAnimalString());
    }
}

