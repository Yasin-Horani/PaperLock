package com.yasin.paperlock.model.mapper;

import com.yasin.paperlock.model.dto.person.*;
import com.yasin.paperlock.model.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPersonEntity(PersonReqDTO personReqDTO);
    PersonDTO toPersonDTO(Person person);
    PersonResDTO toPersonResDTO(Person person);
}
