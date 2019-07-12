package news.browser.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class ArticleTest {
    private Instant publishedAt = Instant.parse("2019-07-12T06:48:43Z");
    private String url = "testUrl";
    private String urlToImage = "testUrlImage";

    private Article article;

    @Before
    public void SetUp() {
        this.article = prepareArticle(publishedAt, url, urlToImage);
    }

    @Test
    public void shouldSerializeCorrectly() {
        Map articleAsMap = new ObjectMapper().convertValue(article, Map.class);

        assertThat(articleAsMap.get("date")).isEqualTo("2019-07-12");
        assertThat(articleAsMap.get("articleUrl")).isEqualTo(url);
        assertThat(articleAsMap.get("imageUrl")).isEqualTo(urlToImage);
    }

    private Article prepareArticle(Instant publishedAt, String url, String urlToImage) {
        Article article = new Article();
        article.setPublishedAt(publishedAt);
        article.setUrl(url);
        article.setUrlToImage(urlToImage);
        return article;
    }
}