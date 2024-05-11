package ooad.failless.community;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CommunityPostDto {
    private Long id;
    private String date;
    private String title;
    private String content;
    private String writerId;
}
