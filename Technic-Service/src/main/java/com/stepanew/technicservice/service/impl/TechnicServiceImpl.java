package com.stepanew.technicservice.service.impl;

import com.stepanew.technicservice.domain.mapper.TechnicResponseDtoMapper;
import com.stepanew.technicservice.domain.model.Technic;
import com.stepanew.technicservice.domain.dto.response.TechnicResponseDto;
import com.stepanew.technicservice.exception.TechnicNotFoundException;
import com.stepanew.technicservice.repository.TechnicRepository;
import com.stepanew.technicservice.service.TechnicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static com.stepanew.technicservice.exception.TechnicNotFoundException.technicNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class TechnicServiceImpl implements TechnicService {

    private final TechnicResponseDtoMapper technicResponseDtoMapper;

    private final TechnicRepository technicRepository;

    @Override
    @Transactional(
            readOnly = true,
            rollbackFor = TechnicNotFoundException.class,
            isolation = Isolation.REPEATABLE_READ
    )
    public TechnicResponseDto getTechnicById(Long technicId) {
        return technicResponseDtoMapper.toDto(findTechnicById(technicId));
    }

    private Technic findTechnicById(Long technicId) {
        log.info("Выполняется ли транзакция - {}", TransactionSynchronizationManager.isActualTransactionActive());
        return technicRepository
                .findById(technicId)
                .orElseThrow(
                        technicNotFoundException(technicId)
                );
    }

}
