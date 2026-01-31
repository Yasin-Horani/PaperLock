package com.yasin.paperlock.controller;

import com.yasin.paperlock.model.dto.person.PersonDTO;
import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;
import com.yasin.paperlock.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/persons/v1.0.0/")
@Slf4j
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/person")
    public PersonResDTO createPerson(@RequestBody PersonReqDTO personReqDTO) {
        log.info("Create person: {}", personReqDTO);
        return this.personService.addPerson(personReqDTO);
    }

    @GetMapping("/person")
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }
}
