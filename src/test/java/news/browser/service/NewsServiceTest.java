package news.browser.service;

import news.browser.model.NewsServiceResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {

    @Mock
    private RestTemplate restTemplate;
    private NewsService newsService;

    @Before
    public void setUp() {
        this.newsService = new NewsService("TEST_API_KEY", restTemplate);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(NewsServiceResponse.class))).thenReturn(new ResponseEntity<>(HttpStatus.OK));
    }

    @Test
    public void whenGettingArticles_shouldSendRequest() {
        newsService.getArticles("testCountry", "testCategory");

        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(NewsServiceResponse.class));
    }
}