package com.yasin.paperlock.service.impl;

import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;
import com.yasin.paperlock.model.entity.Person;
import com.yasin.paperlock.model.mapper.PersonMapper;
import com.yasin.paperlock.repository.PersonRepo;
import com.yasin.paperlock.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;
    private final PersonMapper personMapper;

    @Override
    public PersonResDTO addPerson(PersonReqDTO personReqDTO) {
        Person person = this.personMapper.toPersonEntity(personReqDTO);
        Person savedPerson = this.personRepo.save(person);
        return personMapper.toPersonResDTO(savedPerson);
    }
}
