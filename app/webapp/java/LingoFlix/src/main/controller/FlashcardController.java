package main.controller;

import main.model.Flashcard;
import main.model.VideoSuggestion;
import main.service.AnkiService;
import main.service.SubtitleService;
import service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlashcardController {

    @Autowired
    private AnkiService ankiService;

    @Autowired
    private SubtitleService subtitleService;

    @Autowired
    private FlashcardService flashcardService;

    // Get flashcards from a selected deck
    @GetMapping("/getDeckCards/{deckname}")
    public List<Flashcard> getDeckCards(@PathVariable String deckname) {
        return ankiService.getDeckCards(deckname);
    }

    // Retrieve a single flashcard by ID
    @GetMapping("/getFlashcard/{cardID}")
    public Flashcard getFlashcard(@PathVariable String cardID) {
        return ankiService.getFlashcard(cardID);
    }

    // Search for videos containing a Kanji word
    @GetMapping("/getVideoSuggestions/{word}")
    public List<VideoSuggestion> getVideoSuggestions(@PathVariable String word) {
        return subtitleService.searchWord(word);
    }

    // Save an updated flashcard
    @PostMapping("/saveFlashcard")
    public String saveFlashcard(@RequestBody Flashcard flashcard) {
        return ankiService.saveCard(flashcard);
    }
}
