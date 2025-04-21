package com.book.bookonline.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
//@SuperBuilder //todo : Bu anotasiya ne ucun istifade edilir?
public class Book extends BaseEntity{

    private String title;

    private String authorName;

    @Enumerated(value = EnumType.STRING)
    private BookStatus bookStatus;

    private String publisher;

    private Integer lastPageNumber;

    private Integer totalPage;

    @OneToOne
    private Image image;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
