package ooad.failless.member;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.entities.MemberInfoDto;
import ooad.failless.member.entities.MemberSigninDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/signin")
    public MemberInfoDto signin(@RequestBody MemberSigninDto memberSigninDto) throws Exception{
        return memberService.signin(memberSigninDto);
    }

    @GetMapping("/member/signup")
    public MemberInfoDto signup(@RequestBody MemberSigninDto memberSigninDto) throws Exception{
        return memberService.signup(memberSigninDto);
    }

}
