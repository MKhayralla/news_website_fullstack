package com.homain.interview.task.news.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.homain.interview.task.news.item.ItemRequest;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoriesRepo ;
    /*@Autowired
    public CategoryService(CategoryRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }*/

    public List<Category> getCategories() {
        return categoriesRepo.findAll() ;
    }
    public Optional<Category> findCategory(Long id){
        return categoriesRepo.findById(id) ;
    }
    public List<ItemRequest> getNews(Long id){
        return categoriesRepo.getById(id)
        .getItems()
        .parallelStream()
        .map(item -> new ItemRequest(item))
        .collect(Collectors.toList()) ;
    }
}
