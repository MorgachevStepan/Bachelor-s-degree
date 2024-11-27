package com.stepanew.technicservice.repository;

import com.stepanew.technicservice.domain.model.Technic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicRepository extends JpaRepository<Technic, Long> {
}

