package ooad.failless.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ArticleDto {
    private Long id;
    private String date;
    private String subject;
    private String title;
    private String content;
    private String writerId;
}
