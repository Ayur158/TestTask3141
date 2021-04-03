package test;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Lord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    @OneToMany(mappedBy ="lord", fetch = FetchType.EAGER)
    private Set<Planet> planetSet;

    public Lord() {
    }

    public Lord(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Planet> getPlanetSet() {
        return planetSet;
    }

    public void setPlanetSet(Set<Planet> planetSet) {
        this.planetSet = planetSet;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getAge() + " " + getPlanetSet().toString() ;
    }
}
