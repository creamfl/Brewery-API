package Brewery.demo.Brewery;

import jakarta.persistence.*;

@Entity
@Table
public class Brewery {
    @Id
    @SequenceGenerator(
            name = "brewery_sequence",
            sequenceName = "brewery_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brewery_sequence"
    )
    private Long id;
    private String name;
    private String location;
    private Integer establishedYear;

    public Brewery() {
    }

    public Brewery(Long id, String name, String location, Integer establishedYear) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.establishedYear = establishedYear;
    }

    public Brewery(String name, String location, Integer establishedYear) {
        this.name = name;
        this.location = location;
        this.establishedYear = establishedYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(Integer establishedYear) {
        this.establishedYear = establishedYear;
    }

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", establishedYear=" + establishedYear +
                '}';
    }
}
