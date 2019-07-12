package news.browser.model;

import lombok.Getter;

import java.util.List;

@Getter
public class RegionalNews {
    private String country;
    private String category;
    private List<Article> articles;

    public RegionalNews(String country, String category, List<Article> articles) {
        this.country = country;
        this.category = category;
        this.articles = articles;
    }
}