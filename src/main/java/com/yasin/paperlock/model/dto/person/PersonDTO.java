package com.yasin.paperlock.model.dto.person;

import lombok.Builder;


@Builder
public record PersonDTO(Long personId, String personName) {
}
