package news.browser.controller;

import news.browser.model.Article;
import news.browser.model.RegionalNews;
import news.browser.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewsControllerTest {

    @Mock
    private NewsService newsService;
    @InjectMocks
    private NewsController newsController;

    @Test
    public void whenGettingNews_shouldCallServiceAndReturnNews() {
        String testCountry = "testCountry";
        String testCategory = "testCategory";
        List<Article> articles = Collections.singletonList(new Article());

        when(newsService.getArticles(anyString(), anyString())).thenReturn(articles);

        RegionalNews news = newsController.getNews(testCountry, testCategory);

        verify(newsService).getArticles(testCountry, testCategory);
        assertThat(news.getCountry()).isEqualTo(testCountry);
        assertThat(news.getCategory()).isEqualTo(testCategory);
        assertThat(news.getArticles()).isEqualTo(articles);
    }
}