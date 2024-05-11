package ooad.failless.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CommentDto {
    private Long id;
    private String content;
    private String writerId;
    private Long postId;
}
