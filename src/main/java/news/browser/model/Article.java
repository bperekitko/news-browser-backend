package news.browser.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Getter
public class Article {
    private String author;
    private String title;
    private String description;
    private Instant publishedAt;
    private String sourceName;
    private String url;
    private String urlToImage;

    @JsonGetter("date")
    public String getPublishedAt() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(publishedAt);
    }

    @JsonSetter("publishedAt")
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonGetter("articleUrl")
    public String getUrl() {
        return url;
    }

    @JsonSetter("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonGetter("imageUrl")
    public String getUrlToImage() {
        return urlToImage;
    }

    @JsonSetter("urlToImage")
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @JsonGetter("sourceName")
    public String getSourceName() {
        return sourceName;
    }

    @JsonSetter("source")
    private void setSourceName(Map<String, String> source) {
        this.sourceName = source.get("name");
    }
}