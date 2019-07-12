package news.browser.model;

import lombok.Getter;

import java.util.List;

@Getter
public class NewsServiceResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}