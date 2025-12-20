package com.louazri.webapplication.service;

import com.louazri.webapplication.constants.WebappConstants;
import com.louazri.webapplication.model.Person;
import com.louazri.webapplication.model.Roles;
import com.louazri.webapplication.repository.PersonRepository;
import com.louazri.webapplication.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;

    public Boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(WebappConstants.STUDENT_ROLE);
        person.setRoles(role);
        Person savedPerson = personRepository.save(person);
        if (savedPerson.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
