package Brewery.demo.Beer;

import jakarta.persistence.*;

@Entity
@Table
public class Beer {
    @Id
    @SequenceGenerator(
            name = "beer_sequence",
            sequenceName = "beer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "beer_sequence"
    )
    private Long id;
    private String name;
    private Integer alcoholPercent;

    public Beer() {
    }

    public Beer(Long id, String name, Integer alcoholPercent) {
        this.id = id;
        this.name = name;
        this.alcoholPercent = alcoholPercent;
    }

    public Beer(String name, Integer alcoholPercent) {
        this.name = name;
        this.alcoholPercent = alcoholPercent;
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

    public Integer getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(Integer alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alcoholPercent=" + alcoholPercent +
                '}';
    }
}
