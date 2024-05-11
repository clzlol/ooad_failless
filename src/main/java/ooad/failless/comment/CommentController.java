package ooad.failless.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public List<CommentDto> getAllComments(@RequestParam Long postId) {
        return commentService.getAllComments(postId);
    }

    @PostMapping("/comment")
    public void writeComment(@RequestBody CommentDto commentDto) {
        commentService.writeComment(commentDto);
    }
}
