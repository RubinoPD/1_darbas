package lt.viko.eif.r.kaskur.vet.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Represents a Person with various attributes and a list of associated Animals.
 */
@XmlRootElement(name = "person")
@XmlType(propOrder = {"id", "name", "age", "height", "married", "initial", "animals"})
public class Person {

    private int id;
    private String name;
    private int age;
    private float height;
    private boolean isMarried;
    private char initial;
    private List<Animal> animals;

    /**
     * Default constructor.
     */
    public Person() {}

    /**
     * Parameterized constructor.
     *
     * @param id       the ID of the person
     * @param name     the name of the person
     * @param age      the age of the person
     * @param height   the height of the person
     * @param married indicates if the person is married
     * @param initial  the initial of the person
     * @param animals  the list of animals associated with the person
     */
    public Person(int id, String name, int age, float height, boolean married, char initial, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.isMarried = married;
        this.initial = initial;
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
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @XmlElement
    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        this.isMarried = married;
    }

    @XmlElement
    public char getInitial() {
        return initial;
    }

    public void setInitial(char initial) {
        this.initial = initial;
    }

    @XmlElement
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
