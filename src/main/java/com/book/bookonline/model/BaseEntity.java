package com.book.bookonline.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass //todo : Bu anotasiya ne ucun istifade edilir?
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @CreationTimestamp //todo : Bu anotasiya ne ucun istifade edilir?
    private LocalDateTime createDate = LocalDateTime.now();

    @UpdateTimestamp //todo : Bu anotasiya ne ucun istifade edilir?
    private LocalDateTime updateDate;
}
