package news.browser.controller;

import news.browser.model.Article;
import news.browser.model.RegionalNews;
import news.browser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news/{country}/{category}")
    RegionalNews getNews(@PathVariable String country, @PathVariable String category) {
        List<Article> articles = newsService.getArticles(country, category);
        return new RegionalNews(country, category, articles);
    }
}