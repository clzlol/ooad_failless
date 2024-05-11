package ooad.failless.member;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.entities.Member;
import ooad.failless.member.entities.MemberInfoDto;
import ooad.failless.member.entities.MemberSigninDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberInfoDto signin(MemberSigninDto memberSigninDto) {
        Member member = memberRepository.findById(memberSigninDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong id"));

        if (!member.getPw().equals(memberSigninDto.getPw())) {
            throw new IllegalArgumentException("wrong password");
        }

        return MemberInfoDto.builder()
                .id(member.getId())
                .pw(member.getPw())
                .manager(member.isManager())
                .build();
    }

    public MemberInfoDto signup(MemberSigninDto memberSigninDto) throws Exception {
        if (memberRepository.findById(memberSigninDto.getId()).isPresent()) {
            throw new Exception("id already exists");
        }

        Member member = Member.builder()
                .id(memberSigninDto.getId())
                .pw(memberSigninDto.getPw())
                .manager(false)
                .build();
        memberRepository.save(member);

        return MemberInfoDto.builder()
                .id(member.getId())
                .pw(member.getPw())
                .manager(member.isManager())
                .build();
    }
}
