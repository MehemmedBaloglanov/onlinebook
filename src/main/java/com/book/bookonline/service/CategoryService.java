package com.book.bookonline.service;

import com.book.bookonline.model.Category;
import com.book.bookonline.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow();
    }

    public Category findByName(String value) {
        return categoryRepository.findByName(value).orElseThrow(RuntimeException::new);
    }
}
