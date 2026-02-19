package com.yasin.paperlock.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_cost")
    private BigDecimal productCost;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @Column(name = "bill_status")
    private String billStatus;

    @Column(name = "bill_image_url")
    private String billImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
