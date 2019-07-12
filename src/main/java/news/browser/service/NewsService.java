package news.browser.service;

import news.browser.model.Article;
import news.browser.model.NewsServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private static final String NEWS_SERVICE_URL_TEMPLATE = "https://newsapi.org/v2/top-headlines?country={0}&category={1}";

    private String apiKey;
    private RestTemplate restTemplate;

    @Autowired
    public NewsService(@Value("${newsservice.apikey}") String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public List<Article> getArticles(String country, String category) {
        NewsServiceResponse response = getResponse(country, category);
        return Optional.ofNullable(response).isPresent() ? response.getArticles() : new ArrayList<>();
    }

    private NewsServiceResponse getResponse(String country, String category) {
        HttpHeaders headers = buildAuthenticationHeaders();
        String URL = MessageFormat.format(NEWS_SERVICE_URL_TEMPLATE, country, category);

        return restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity<>(headers), NewsServiceResponse.class).getBody();
    }

    private HttpHeaders buildAuthenticationHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        return headers;
    }
}