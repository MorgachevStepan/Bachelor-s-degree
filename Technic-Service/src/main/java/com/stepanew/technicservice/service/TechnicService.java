package com.stepanew.technicservice.service;

import com.stepanew.technicservice.domain.dto.response.TechnicResponseDto;

public interface TechnicService {

    TechnicResponseDto getTechnicById(Long technicId);

}
