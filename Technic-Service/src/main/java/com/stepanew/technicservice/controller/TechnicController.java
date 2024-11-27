package com.stepanew.technicservice.controller;

import com.stepanew.technicservice.domain.dto.response.TechnicResponseDto;
import com.stepanew.technicservice.service.TechnicService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/technics")
public class TechnicController {

    private final TechnicService technicService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TechnicResponseDto getTechnicById(
            @PathVariable @Min(value = 1, message = "ID техники должен быть больше или равен 1") Long id
    ) {
        return technicService.getTechnicById(id);
    }

}
