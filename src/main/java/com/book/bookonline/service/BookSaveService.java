package com.book.bookonline.service;

import com.book.bookonline.dto.BookListItemResponse;
import com.book.bookonline.dto.SaveBookRequest;
import com.book.bookonline.model.Book;
import com.book.bookonline.model.Category;
import com.book.bookonline.repository.BookRepository;
import com.book.bookonline.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookSaveService {

    private final BookRepository bookRepository;

    private final CategoryService categoryService;


    @Transactional
    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest){
        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());
        final Book book = Book.builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .authorName(saveBookRequest.getAuthorName())
                .totalPage(saveBookRequest.getTotalPage())
                .build();
        final Book saveDB = bookRepository.save(book);

        return BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(saveDB.getId())
                .bookStatus(saveDB.getBookStatus())
                .publisher(saveDB.getPublisher())
                .authorName(saveDB.getAuthorName())
                .totalPage(saveDB.getTotalPage())
                .lastPageNumber(saveDB.getLastPageNumber())
                .build();
    }
}
