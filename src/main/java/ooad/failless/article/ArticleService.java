package ooad.failless.article;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.MemberRepository;
import ooad.failless.member.entities.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public void writeArticle(ArticleDto articleDto) {
        Member member = memberRepository.findById(articleDto.getWriterId())
                        .orElseThrow(() -> new IllegalArgumentException("id doesn't exist"));

        articleRepository.save(Article.builder()
                        .id(articleDto.getId())
                        .date(articleDto.getDate())
                        .title(articleDto.getTitle())
                        .subject(articleDto.getSubject())
                        .content(articleDto.getContent())
                        .member(member)
                        .build());
    }

    public List<ArticleDto> getAllArticle() {
        List<Article> articleList = articleRepository.findAll();
        if (articleList.isEmpty()) {
            throw new IllegalArgumentException("article list is empty");
        }

        return articleList.stream()
                .map(article -> ArticleDto.builder()
                        .id(article.getId())
                        .date(article.getDate())
                        .subject(article.getSubject())
                        .title(article.getTitle())
                        .content(article.getContent())
                        .writerId(article.getMember().getId())
                        .build())
                .toList();
    }

    public ArticleDto getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("wrong article id"));

        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .subject(article.getSubject())
                .date(article.getDate())
                .content(article.getContent())
                .writerId(article.getMember().getId())
                .build();
    }

}
