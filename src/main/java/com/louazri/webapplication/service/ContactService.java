package com.louazri.webapplication.service;


import com.louazri.webapplication.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ContactService {
    private static Logger log = LoggerFactory.getLogger(ContactService.class);
    /**
     * save Contact details into Db
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetail(Contact contact) {
        boolean isSaved = true;
        //TODO -Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}

