package ooad.failless.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooad.failless.community.CommunityPost;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
    @Column(nullable = false)
    private String writerId;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private CommunityPost communityPost;
}
