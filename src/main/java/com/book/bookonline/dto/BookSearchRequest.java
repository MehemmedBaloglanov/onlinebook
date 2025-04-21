package com.book.bookonline.dto;

import lombok.Getter;

@Getter
public class BookSearchRequest {
    private int size;
    private int page;
}
