package Brewery.demo.TastingNote;

import Brewery.demo.Beer.Beer;
import jakarta.persistence.*;

@Entity
@Table
public class TastingNote {
    @Id
    @SequenceGenerator(
            name = "tastingNote_sequence",
            sequenceName = "tastingNote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tastingNote_sequence"
    )
    private Long id;

    private String note;

    @ManyToOne
    @JoinColumn(name = "beer_id", nullable = false)
    private Beer beer;

    public TastingNote() {
    }

    public TastingNote(Long id, String note, Beer beer) {
        this.id = id;
        this.note = note;
        this.beer = beer;
    }

    public TastingNote(String note, Beer beer) {
        this.note = note;
        this.beer = beer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public String toString() {
        return "TastingNote{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", beer=" + beer +
                '}';
    }
}
