package ooad.failless.member;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.entities.MemberInfoDto;
import ooad.failless.member.entities.MemberSigninDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/signin")
    public MemberInfoDto signin(@RequestBody MemberSigninDto memberSigninDto) throws Exception{
        return memberService.signin(memberSigninDto);
    }

    @PostMapping("/member/signup")
    public MemberInfoDto signup(@RequestBody MemberSigninDto memberSigninDto) throws Exception{
        return memberService.signup(memberSigninDto);
    }

    @GetMapping("/member/manage")
    public boolean changeManager(@RequestParam String id) {
        return memberService.changeManager(id);
    }

}
