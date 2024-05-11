package ooad.failless.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public void writeArticle(@RequestBody ArticleDto articleDto) {
        articleService.writeArticle(articleDto);
    }

    @GetMapping("/article/all")
    public List<ArticleDto> getAllArticle() {
        return articleService.getAllArticle();
    }

    @GetMapping("/article")
    public ArticleDto getArticle(@RequestParam Long id) {
        return articleService.getArticle(id);
    }
}
