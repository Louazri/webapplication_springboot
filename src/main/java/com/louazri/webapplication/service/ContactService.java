package com.louazri.webapplication.service;


import com.louazri.webapplication.constants.WebappConstants;
import com.louazri.webapplication.model.Contact;
import com.louazri.webapplication.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public boolean saveMessageDetail(Contact contact) {
        contact.setStatus(WebappConstants.OPEN);
        contact.setCreatedBy(WebappConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        return contactRepository.save(contact).getContactId() > 0;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findByStatus(WebappConstants.OPEN);

    }

    public boolean updateMsgStatus(int contactId , String updatedBy){
      return contactRepository.updateMsgStatus(
                contactId,
                WebappConstants.CLOSED,
                updatedBy
      ) > 0;
    }

}

