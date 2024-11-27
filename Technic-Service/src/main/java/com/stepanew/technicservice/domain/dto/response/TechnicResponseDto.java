package com.stepanew.technicservice.domain.dto.response;

public record TechnicResponseDto(

        Long technicId,

        Long accountId,

        String model,

        String brand,

        String licence,

        Integer year,

        String vinCode,

        String type

) {
}
