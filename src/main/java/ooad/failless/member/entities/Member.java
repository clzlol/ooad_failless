package ooad.failless.member.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooad.failless.article.Article;
import ooad.failless.community.CommunityPost;
import ooad.failless.contact.Contact;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String id;

    @Column(nullable = false)
    private String pw;
    @Column
    private boolean manager;

    @OneToMany(mappedBy = "member")
    private List<CommunityPost> communityPosts;

    @OneToMany(mappedBy = "member")
    private List<Contact> contacts;

    @OneToMany(mappedBy = "member")
    private List<Article> articles;
}
