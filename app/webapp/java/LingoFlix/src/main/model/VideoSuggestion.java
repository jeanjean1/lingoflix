package main.model;

public class VideoSuggestion {
    private String title;
    private String url;

    public VideoSuggestion(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // Getters
    public String getTitle() { return title; }
    public String getUrl() { return url; }
}
