package news.browser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import news.browser.model.Article;
import news.browser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news/{country}/{category}")
    public String getNews(@PathVariable String country, @PathVariable String category) throws JsonProcessingException {
        List<Article> articles = newsService.getArticles(country, category);
        return new ObjectMapper().writeValueAsString(articles);
    }
}