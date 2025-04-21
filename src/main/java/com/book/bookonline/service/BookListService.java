package com.book.bookonline.service;

import com.book.bookonline.dto.BookResponse;
import com.book.bookonline.dto.BookSearchRequest;
import com.book.bookonline.dto.CategoryType;
import com.book.bookonline.model.Book;
import com.book.bookonline.model.BookStatus;
import com.book.bookonline.model.Category;
import com.book.bookonline.repository.BookRepository;
import com.book.bookonline.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookListService {

    private final CategoryService categoryService;
    private final BookRepository bookRepository;

    //CONVERT REQUEST PARAM
    public List<BookResponse> listBooks(int size, int page) {
       return bookRepository.findAll(PageRequest.of(page, size))
               .getContent()
               .stream()
               .map(BookListService::convertResponse).collect(Collectors.toList());
    }



    public List<BookResponse> searchByCategory(CategoryType categoryType) {
        final Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService :: convertResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus).stream()
                .map(model ->
                        BookResponse.builder()
                                .imageUrl(model.getImage().getImageUrl())
                                .bookId(model.getId())
                                .build()).collect(Collectors.toList());
    }

    public List<BookResponse> searchByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(model ->
                       BookResponse.builder().bookId(model.getId())
                               .imageUrl(model.getImage().getImageUrl())
                               .build()).collect(Collectors.toList());
    }

    private static BookResponse convertResponse(Book model) {
        return BookResponse.builder()
                .title(model.getTitle())
                .authorName(model.getAuthorName())
                .imageUrl(model.getImage().getImageUrl())
                .build();
    }
}
