package com.louazri.webapplication.service;


import com.louazri.webapplication.constants.WebappConstants;
import com.louazri.webapplication.model.Contact;
import com.louazri.webapplication.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public boolean saveMessageDetail(Contact contact) {
        contact.setStatus(WebappConstants.OPEN);
        return contactRepository.save(contact).getContactId() > 0;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findByStatus(WebappConstants.OPEN);

    }


    @Transactional
    public boolean updateMsgStatus(int contactId) {

        return contactRepository.findById(contactId)
                .map(contact -> {
                    contact.setStatus(WebappConstants.CLOSED);
                    return true;
                })
                .orElse(false);
    }


}

