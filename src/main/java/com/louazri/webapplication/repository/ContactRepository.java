package com.louazri.webapplication.repository;

import com.louazri.webapplication.model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);


    @Modifying
    @Transactional
    @Query("""
    update Contact c
    set c.status = :status,
        c.updatedBy = :updatedBy,
        c.updatedAt = CURRENT_TIMESTAMP
    where c.contactId = :contactId
    """)
    int updateMsgStatus(@Param("contactId") int contactId,
                        @Param("status") String status,
                        @Param("updatedBy") String updatedBy);



}
