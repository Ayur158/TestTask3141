package test;

import javax.persistence.*;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "lord_id")
    private Lord lord;

    public Planet(long id, String name, Lord lord) {
        this.id = id;
        this.name = name;
        this.lord = lord;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Planet() {
    }

    public Planet(Long id, String name  ) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    @Override
    public String toString() {
        return getName();
    }
    public String toStrings() {
        return getId() + " " + getName() + " " + getLord().getName();
    }

    public boolean equals(Planet planet) {
        return planet.id == this.id & planet.name.equals(this.name) & planet.lord.equals(this.lord);
    }
}
