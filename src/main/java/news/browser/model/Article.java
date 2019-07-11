package news.browser.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class Article implements Serializable {
    private String author;
    private String title;
    private String description;
    private String sourceName;

    @JsonProperty("publishedAt")
    private String date;

    @JsonProperty("url")
    private String articleUrl;

    @JsonProperty("urlToImage")
    private String imageUrl;

    @JsonProperty("source")
    private void parseSourceNameFromJson(Map<String, String> source) {
        this.sourceName = source.get("name");
    }
}