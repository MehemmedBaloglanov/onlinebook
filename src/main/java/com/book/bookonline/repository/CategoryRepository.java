package com.book.bookonline.repository;

import com.book.bookonline.model.Book;
import com.book.bookonline.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Book> {

//    JpaSpecificationExecutor //todo : Bu ne ucun istifade edilir?

    Optional<Category> findByName(String name);
}
