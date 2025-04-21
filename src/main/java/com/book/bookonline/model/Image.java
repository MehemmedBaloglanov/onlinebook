package com.book.bookonline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "images")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity{

    private String imageUrl;
}
