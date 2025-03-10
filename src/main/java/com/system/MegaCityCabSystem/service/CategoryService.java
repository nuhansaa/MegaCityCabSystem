package com.system.MegaCityCabSystem.service;

import org.springframework.stereotype.Service;
import com.system.MegaCityCabSystem.model.Category;
import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category updateCategory(String categoryId, Category category);
    void deleteCategory(String categoryId);
}
