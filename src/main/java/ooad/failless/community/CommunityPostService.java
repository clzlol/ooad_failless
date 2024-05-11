package ooad.failless.community;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.MemberRepository;
import ooad.failless.member.entities.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityPostService {

    private final CommunityPostRepository communityPostRepository;
    private final MemberRepository memberRepository;

    public List<CommunityPostDto> getAllPosts() {
        List<CommunityPost> communityPostList = communityPostRepository.findAll();
        if(communityPostList.isEmpty()) {
            throw new IllegalArgumentException("communityPost list is empty");
        }

        return communityPostList.stream()
                .map(post -> CommunityPostDto.builder()
                        .id(post.getId())
                        .date(post.getDate())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .writerId(post.getMember().getId())
                        .build())
                .toList();
    }

    public CommunityPostDto getPost(Long id) {
        CommunityPost communityPost = communityPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("wrong post id"));

        return CommunityPostDto.builder()
                .id(communityPost.getId())
                .date(communityPost.getDate())
                .title(communityPost.getTitle())
                .content(communityPost.getContent())
                .writerId(communityPost.getMember().getId())
                .build();
    }

    public void writePost(CommunityPostDto communityPostDto) {
        Member member = memberRepository.findById(communityPostDto.getWriterId())
                        .orElseThrow(() -> new IllegalArgumentException("wrong writer id"));

        communityPostRepository.save(CommunityPost.builder()
                        .id(communityPostDto.getId())
                        .date(communityPostDto.getDate())
                        .title(communityPostDto.getTitle())
                        .content(communityPostDto.getContent())
                        .member(member)
                        .build());
    }
}
