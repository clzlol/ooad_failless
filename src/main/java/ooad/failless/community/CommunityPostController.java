package ooad.failless.community;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommunityPostController {

    private final CommunityPostService communityPostService;

    @GetMapping("/community/all")
    public List<CommunityPostDto> getAllPosts() {
        return communityPostService.getAllPosts();
    }

    @GetMapping("/community")
    public CommunityPostDto getPost(@RequestParam Long id) {
        return communityPostService.getPost(id);
    }

    @PostMapping("/community")
    public void writePost(@RequestBody CommunityPostDto communityPostDto) {
        communityPostService.writePost(communityPostDto);
    }
}
