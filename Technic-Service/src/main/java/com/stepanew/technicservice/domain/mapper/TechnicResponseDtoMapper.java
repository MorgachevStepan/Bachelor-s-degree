package com.stepanew.technicservice.domain.mapper;

import com.stepanew.technicservice.domain.dto.response.TechnicResponseDto;
import com.stepanew.technicservice.domain.model.Technic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicResponseDtoMapper extends DefaultMapper<TechnicResponseDto, Technic> {
}
