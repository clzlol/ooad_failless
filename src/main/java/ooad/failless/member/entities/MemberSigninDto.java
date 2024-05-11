package ooad.failless.member.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberSigninDto {
    private String id;
    private String pw;
}
