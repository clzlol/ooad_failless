package ooad.failless.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ContactDto {
    private Long id;
    private String content;
    private String senderId;
    private String receiverId;
}
