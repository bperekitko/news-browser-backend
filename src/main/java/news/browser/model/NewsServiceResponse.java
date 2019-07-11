package news.browser.model;

import java.io.Serializable;
import java.util.List;

public class NewsServiceResponse implements Serializable {
    private String status;
    private int resultsCount;
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }
}