package com.yasin.paperlock.service;

import com.yasin.paperlock.model.dto.person.PersonDTO;
import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;
import com.yasin.paperlock.model.dto.person.PersonUpdateDTO;

import java.util.List;

public interface PersonService {

    // add new person
    PersonResDTO addPerson(PersonReqDTO personReqDTO);

    List<PersonDTO> getAllPersons();

    PersonDTO updatePerson(Long personId, PersonUpdateDTO personUpdateDTO);
}
