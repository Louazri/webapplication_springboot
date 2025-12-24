package com.louazri.webapplication.service;

import com.louazri.webapplication.constants.WebappConstants;
import com.louazri.webapplication.model.Person;
import com.louazri.webapplication.model.Roles;
import com.louazri.webapplication.repository.PersonRepository;
import com.louazri.webapplication.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(WebappConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
