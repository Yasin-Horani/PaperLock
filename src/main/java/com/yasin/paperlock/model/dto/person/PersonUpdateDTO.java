package com.yasin.paperlock.model.dto.person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonUpdateDTO {
    private Long personId;
    private String personName;
}
