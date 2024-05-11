package ooad.failless.contact;

import lombok.RequiredArgsConstructor;
import ooad.failless.member.MemberRepository;
import ooad.failless.member.entities.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final MemberRepository memberRepository;

    public void setContact(ContactDto contactDto) {
        Member member = memberRepository.findById(contactDto.getReceiverId())
                        .orElseThrow(() -> new IllegalArgumentException("wrong receiver id"));

        contactRepository.save(Contact.builder()
                        .id(contactDto.getId())
                        .content(contactDto.getContent())
                        .senderId(contactDto.getSenderId())
                        .member(member)
                        .build());
    }

    public List<ContactDto> getReceivingContacts(String receiverId) {
        Member member = memberRepository.findById(receiverId)
                .orElseThrow(() -> new IllegalArgumentException("wrong receiver id"));

        return member.getContacts().stream()
                .map(contact -> ContactDto.builder()
                        .id(contact.getId())
                        .content(contact.getContent())
                        .senderId(contact.getSenderId())
                        .receiverId(contact.getMember().getId())
                        .build())
                .toList();
    }

    public ContactDto getContact(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("wrong contact id"));

        return ContactDto.builder()
                .id(contact.getId())
                .content(contact.getContent())
                .senderId(contact.getSenderId())
                .receiverId(contact.getMember().getId())
                .build();
    }
}
