package Brewery.demo.TastingNote;

import Brewery.demo.Beer.Beer;
import Brewery.demo.Beer.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TastingNoteService {
    private final TastingNoteRepository tastingNoteRepository;
    private final BeerRepository beerRepository;

    @Autowired
    public TastingNoteService(TastingNoteRepository tastingNoteRepository, BeerRepository beerRepository) {
        this.tastingNoteRepository = tastingNoteRepository;
        this.beerRepository = beerRepository;
    }

    public List<TastingNote> getTastingNote() {
        return tastingNoteRepository.findAll();
    }

    public Optional<TastingNote> getTastingNoteById(Long tastingNoteId) {
        return tastingNoteRepository.findById(tastingNoteId);
    }


    public void addNewTastingNote(TastingNote tastingNote, Long beerId) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new IllegalStateException("Beer with id " + beerId + " does not exist"));

        // Check if a tasting note for this beer already exists
        List<TastingNote> tastingNotes = tastingNoteRepository.findTastingNoteByBeer(beer.getName());
        if (!tastingNotes.isEmpty()) {
            throw new IllegalStateException("Tasting note for this beer already exists");
        }

        // Set the beer for the tasting note
        tastingNote.setBeer(beer);
        tastingNoteRepository.save(tastingNote);
    }

    public void deleteTastingNote(Long tastingNoteId) {
        boolean exists = tastingNoteRepository.existsById(tastingNoteId);
        if (!exists) {
            throw new IllegalStateException("Tasting note with id " + tastingNoteId + " does not exist");
        }
        tastingNoteRepository.deleteById(tastingNoteId);
    }

    public void updateTastingNote(Long tastingNoteId, TastingNote tastingNote, Long beerId) {
        TastingNote existingTastingNote = tastingNoteRepository.findById(tastingNoteId)
                .orElseThrow(() -> new IllegalStateException("Tasting note with id " + tastingNoteId + " does not exist"));

        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new IllegalStateException("Beer with id " + beerId + " does not exist"));
        existingTastingNote.setBeer(beer);

        existingTastingNote.setNote(tastingNote.getNote());

        tastingNoteRepository.save(existingTastingNote);
    }
}
