package com.yasin.paperlock.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "letter")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long letterId;


    @Column(name = "letter_sender")
    private String letterSender;

    @Column(name = "letter_info")
    private String letterInfo;

    @Column(name = "receive_date")
    private LocalDate receiveDate;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @Column(name = "letter_status")
    private String letterStatus;

    @Column(name = "letter_image_url")
    private String letterImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
