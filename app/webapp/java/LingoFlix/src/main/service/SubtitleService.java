package main.service;

import main.model.VideoSuggestion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubtitleService {

    public List<VideoSuggestion> searchWord(String word) {
        List<VideoSuggestion> suggestions = new ArrayList<>();

        // Search FilmOT for video clips
        try {
            String url = "https://filmot.com/search/" + word + "/1?gridView=1&searchManualSubs=1&category=19";
            Document doc = Jsoup.connect(url).get();
            Elements videoElements = doc.select(".video-link");

            for (var element : videoElements) {
                suggestions.add(new VideoSuggestion(element.text(), element.attr("href")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return suggestions;
    }
}
