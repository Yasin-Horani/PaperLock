package com.yasin.paperlock.service;

import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;

public interface PersonService {

    // add new person
    PersonResDTO addPerson(PersonReqDTO personReqDTO);
}
