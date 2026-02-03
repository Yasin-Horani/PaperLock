package com.yasin.paperlock.service;

import com.yasin.paperlock.model.dto.person.*;

import java.util.List;

public interface PersonService {

    // add new person
    PersonResDTO addPerson(PersonReqDTO personReqDTO);

    List<PersonDTO> getAllPersons();

    PersonDTO updatePerson(Long personId, PersonUpdateDTO personUpdateDTO);

     void deletePerson(Long personId);

    PersonDTO getOnePerson(Long personId);
}
