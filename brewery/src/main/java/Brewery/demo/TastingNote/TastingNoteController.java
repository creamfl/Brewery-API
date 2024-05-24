package Brewery.demo.TastingNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tastingNote")
public class TastingNoteController {
    private final TastingNoteService tastingNoteService;

    @Autowired
    public TastingNoteController(TastingNoteService tastingNoteService) {
        this.tastingNoteService = tastingNoteService;
    }

    @GetMapping
    public List<TastingNote> getTastingNote() {
        return tastingNoteService.getTastingNote();
    }

    @GetMapping(path = "{tastingNoteId}")
    public TastingNote getTastingNoteById(@PathVariable("tastingNoteId") Long tastingNoteId) {
        return tastingNoteService.getTastingNoteById(tastingNoteId)
                .orElseThrow(() -> new IllegalStateException("Tasting note with id " + tastingNoteId + " does not exist"));
    }

    @PostMapping
    public void registerNewTastingNote(@RequestBody TastingNoteDTO tastingNoteDTO) {
        TastingNote tastingNote = new TastingNote();
        tastingNote.setNote(tastingNoteDTO.getNote());
        tastingNoteService.addNewTastingNote(tastingNote, tastingNoteDTO.getBeerId());
    }

    @DeleteMapping(path = "{tastingNoteId}")
    public void deleteTastingNote(@PathVariable("tastingNoteId") Long tastingNoteId) {
        tastingNoteService.deleteTastingNote(tastingNoteId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateTastingNote(
            @PathVariable Long id,
            @RequestBody TastingNoteDTO tastingNoteDTO) {

        try {
            TastingNote tastingNote = new TastingNote();
            tastingNote.setNote(tastingNoteDTO.getNote());
            tastingNoteService.updateTastingNote(id, tastingNote, tastingNoteDTO.getBeerId());
            return ResponseEntity.ok("Tasting note updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
