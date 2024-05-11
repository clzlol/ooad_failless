package ooad.failless.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public void setContact(@RequestBody ContactDto contactDto) {
        contactService.setContact(contactDto);
    }

    @GetMapping("/contact/all")
    public List<ContactDto> getReceivingContacts(@RequestParam String receiverId) {
        return contactService.getReceivingContacts(receiverId);
    }

    @GetMapping("/contact")
    public ContactDto getContact(@RequestParam Long id) {
        return contactService.getContact(id);
    }
}
