package ooad.failless.comment;

import lombok.RequiredArgsConstructor;
import ooad.failless.community.CommunityPost;
import ooad.failless.community.CommunityPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommunityPostRepository communityPostRepository;

    public List<CommentDto> getAllComments(Long postId) {
        CommunityPost communityPost = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("wrong community id"));
        return communityPost.getComments().stream()
                .map(comment -> CommentDto.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .writerId(comment.getWriterId())
                        .postId(communityPost.getId())
                        .build())
                .toList();
    }

    public void writeComment(CommentDto commentDto) {
        CommunityPost communityPost = communityPostRepository.findById(commentDto.getPostId())
                        .orElseThrow(() -> new IllegalArgumentException("wrong post id"));

        commentRepository.save(Comment.builder()
                        .id(commentDto.getId())
                        .content(commentDto.getContent())
                        .writerId(commentDto.getWriterId())
                        .communityPost(communityPost)
                        .build());
    }
}
