package com.yasin.paperlock;

import com.yasin.paperlock.model.dto.person.PersonDTO;
import com.yasin.paperlock.model.dto.person.PersonReqDTO;
import com.yasin.paperlock.model.dto.person.PersonResDTO;
import com.yasin.paperlock.model.dto.person.PersonUpdateDTO;
import com.yasin.paperlock.model.entity.Person;
import com.yasin.paperlock.model.mapper.PersonMapper;
import com.yasin.paperlock.repository.PersonRepo;
import com.yasin.paperlock.service.impl.PersonServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    @Mock
    private PersonRepo personRepo;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    private Person person;
    private PersonReqDTO personReqDTO;
    private PersonResDTO personResDTO;
    private PersonUpdateDTO personUpdateDTO;
    private PersonDTO personDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        person = new Person();
        person.setPersonId(1L);
        person.setPersonName("John Doe");

        personReqDTO = new PersonReqDTO("John Doe");
        personResDTO = new PersonResDTO( "John Doe");
        personUpdateDTO = new PersonUpdateDTO("Jane Doe");
        personDTO = new PersonDTO(1L, "John Doe");
    }

    @Test
    void testAddPerson() {
        when(personMapper.toPersonEntity(personReqDTO)).thenReturn(person);
        when(personRepo.save(person)).thenReturn(person);
        when(personMapper.toPersonResDTO(person)).thenReturn(personResDTO);

        PersonResDTO result = personService.addPerson(personReqDTO);

        assertEquals(personResDTO, result);
        verify(personRepo, times(1)).save(person);
    }

    @Test
    void testGetAllPersons() {
        when(personRepo.findAll()).thenReturn(Arrays.asList(person));
        when(personMapper.toPersonDTO(person)).thenReturn(personDTO);

        List<PersonDTO> result = personService.getAllPersons();

        assertEquals(1, result.size());
        assertEquals(personDTO, result.get(0));
    }

    @Test
    void testUpdatePerson_Success() {
        when(personRepo.findById(1L)).thenReturn(Optional.of(person));
        when(personRepo.save(any(Person.class))).thenReturn(person);
        when(personMapper.toPersonDTO(person)).thenReturn(personDTO);

        PersonDTO result = personService.updatePerson(1L, personUpdateDTO);

        assertEquals(personDTO, result);
        assertEquals("Jane Doe", person.getPersonName());
        verify(personRepo, times(1)).save(person);
    }

    @Test
    void testUpdatePerson_NotFound() {
        when(personRepo.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> personService.updatePerson(1L, personUpdateDTO));

        assertEquals("Person not found with id: 1", exception.getMessage());
    }

    @Test
    void testDeletePerson_Exists() {
        when(personRepo.existsById(1L)).thenReturn(true);

        personService.deletePerson(1L);

        verify(personRepo, times(1)).deleteById(1L);
    }

    @Test
    void testDeletePerson_NotExists() {
        when(personRepo.existsById(1L)).thenReturn(false);

        personService.deletePerson(1L);

        verify(personRepo, never()).deleteById(anyLong());
    }

    @Test
    void testGetOnePerson_Success() {
        when(personRepo.findById(1L)).thenReturn(Optional.of(person));
        when(personMapper.toPersonDTO(person)).thenReturn(personDTO);

        PersonDTO result = personService.getOnePerson(1L);

        assertEquals(personDTO, result);
    }

    @Test
    void testGetOnePerson_NotFound() {
        when(personRepo.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> personService.getOnePerson(1L));

        assertEquals("Person not found with id: 1", exception.getMessage());
    }
}