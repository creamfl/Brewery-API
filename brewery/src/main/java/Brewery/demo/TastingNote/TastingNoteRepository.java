package Brewery.demo.TastingNote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TastingNoteRepository extends JpaRepository<TastingNote, Long> {
    @Query("SELECT tn FROM TastingNote tn WHERE tn.beer.name = ?1")
    List<TastingNote> findTastingNoteByBeer(String beerName);
}
