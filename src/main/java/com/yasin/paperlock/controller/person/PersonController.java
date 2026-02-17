package com.yasin.paperlock.controller.person;

import com.yasin.paperlock.model.dto.person.PersonDTO;
import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;
import com.yasin.paperlock.model.dto.person.PersonUpdateDTO;
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
        log.info("Create person: {}", personReqDTO.personName());
        return this.personService.addPerson(personReqDTO);
    }

    @GetMapping("/person")
    public List<PersonDTO> getAllPersons() {
        log.info("Get all persons");
        return personService.getAllPersons();
    }

    @PutMapping("/person/{personId}")
    public PersonDTO updatePerson(@PathVariable Long personId,
                                  @RequestBody PersonUpdateDTO personUpdateDTO) {
        log.info("Update person with id {}", personId);
        return personService.updatePerson(personId, personUpdateDTO);
    }

    @DeleteMapping(path = "/person/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        this.personService.deletePerson(personId);
    }

    @GetMapping(path = "/person/{personId}")
    public PersonDTO getOnePeson(@PathVariable Long personId) {
        return this.personService.getOnePerson(personId);
    }
}
