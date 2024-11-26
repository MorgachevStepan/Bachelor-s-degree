package com.stepanew.technicservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "technic", uniqueConstraints = {
        @UniqueConstraint(columnNames = "licence"),
        @UniqueConstraint(columnNames = "vinCode")
})
@Data
@NoArgsConstructor
public class Technic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technic_id")
    private Long technicId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "licence", nullable = false, unique = true)
    private String licence;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "vin_code", nullable = false, unique = true)
    private String vinCode;

    @Column(name = "type")
    private String type;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

}
