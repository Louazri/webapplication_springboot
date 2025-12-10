package com.louazri.webapplication.service;


import com.louazri.webapplication.constants.WebappConstants;
import com.louazri.webapplication.model.Contact;
import com.louazri.webapplication.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;



    /**
     * save Contact details into Db
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetail(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(WebappConstants.OPEN);
        contact.setCreatedBy(WebappConstants.ANONYMOUS);
        contact.setCreatedAT(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(WebappConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId , String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId , WebappConstants.CLOSED , updatedBy);
        if (result > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}

