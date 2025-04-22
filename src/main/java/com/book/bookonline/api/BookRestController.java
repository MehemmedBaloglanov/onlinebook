package com.book.bookonline.api;

import com.book.bookonline.dto.*;
import com.book.bookonline.model.BookStatus;
import com.book.bookonline.service.BookListService;
import com.book.bookonline.service.BookSaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookListService bookListService;

    private final BookSaveService bookSaveService;

    @PostMapping("/save")
    public ResponseEntity<BookListItemResponse> saveBook(@Valid @RequestBody SaveBookRequest saveBookRequest){
        return ResponseEntity
                .status(HttpStatus.SC_CREATED)
                .body(bookSaveService.saveBook(saveBookRequest));

    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBooks(@RequestParam(value = "5") int size,
                                                        @RequestParam(value = "1") int page){
        return ResponseEntity.
                ok(bookListService.listBooks(page,size));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> searchByCategory(@PathVariable("categoryType") CategoryType categoryType){
        return ResponseEntity
                .ok(bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/{bookStatus}")
    public ResponseEntity<List<BookResponse>> searchBookStatus(@PathVariable("bookStatus") BookStatus bookStatus){
        return ResponseEntity
                .ok(bookListService.searchBookStatus(bookStatus));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> searchTitle(@PathVariable("title") String title){
        return ResponseEntity
                .ok(bookListService.searchByTitle(title));
    }
}
