package ooad.failless.contact;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooad.failless.member.entities.Member;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
    @Column(nullable = false)
    private String senderId;

    @ManyToOne
    @JoinColumn(name = "receiverId", nullable = false)
    private Member member;
}
