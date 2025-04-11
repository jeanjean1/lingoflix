package com.example.dictionaryapp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class DictionaryController {

    private static final String API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + word;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            model.addAttribute("word", word);
            model.addAttribute("definition", response.getBody());
        } catch (Exception e) {
            model.addAttribute("error", "Word not found.");
        }

        return "index";
    }
}