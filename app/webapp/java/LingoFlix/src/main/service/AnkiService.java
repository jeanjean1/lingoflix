package main.service;

import main.model.Flashcard;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class AnkiService {

    private static final String ANKICONNECT_URL = "http://localhost:8765";

    public List<Flashcard> getDeckCards(String deckname) {
        String query = "{\"action\":\"findNotes\",\"version\":6,\"params\":{\"query\":\"deck:" + deckname + "\"}}";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(ANKICONNECT_URL, query, List.class);
    }

    public Flashcard getFlashcard(String cardID) {
        String query = "{\"action\":\"notesInfo\",\"version\":6,\"params\":{\"notes\":[" + cardID + "]}}";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(ANKICONNECT_URL, query, Flashcard.class);
    }

    public String saveCard(Flashcard flashcard) {
        String query = "{\"action\":\"updateNoteFields\",\"version\":6,\"params\":{\"note\":{\"id\":" + flashcard.getId() +
                ",\"fields\":{\"Back\":\"" + flashcard.getBack() + "\"}}}}";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(ANKICONNECT_URL, query, String.class);
    }
}
