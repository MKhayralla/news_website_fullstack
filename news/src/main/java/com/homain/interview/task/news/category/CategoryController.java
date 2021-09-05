package com.homain.interview.task.news.category;

import java.util.List;

import com.homain.interview.task.news.item.ItemRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryService service ;
    /*@Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }
    */
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = service.getCategories() ;
        return ResponseEntity.ok().body(categories) ;
    }

    @GetMapping("/{id}/news")
    public ResponseEntity<List<ItemRequest>> getCategoryItems(@PathVariable("id") Long id) {
        List<ItemRequest> items = service.getNews(id) ;
        return ResponseEntity.ok().body(items) ;
    }
}
