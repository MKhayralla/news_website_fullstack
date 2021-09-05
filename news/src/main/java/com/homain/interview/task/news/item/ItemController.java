package com.homain.interview.task.news.item;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.homain.interview.task.news.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@RequestMapping("api/news")
public class ItemController {
    @Autowired
    private ItemService service ;
    @Autowired
    private CategoryService categoriesService ;
    private ResponseEntity<ItemRequest> create(ItemRequest item) {
        Item created = service.createItem(item) ;
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(created.getId())
        .toUri() ;
        return ResponseEntity.created(location).body(new ItemRequest(created)) ; 
    }
    @GetMapping
    public ResponseEntity<List<ItemRequest>> getAllNews() {
        List<ItemRequest> items = service.getNews() ;
        return ResponseEntity.ok().body(items) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id){
        Optional<Item> item = service.getItem(id) ;
        return ResponseEntity.of(item) ;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('create:news')")
    public ResponseEntity<ItemRequest> postItem(@RequestBody ItemRequest item){
        return create(item) ;
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:news')")
    public ResponseEntity<ItemRequest> editItem(@PathVariable("id") Long id,
    @RequestBody ItemRequest newData) {
        Item updated = service.updateItem(id, new Item(
            newData.getTitle(),
            newData.getDescription(),
            newData.getImage(),
            categoriesService.findCategory(newData.getCategory()).get()
        )) ;
        return ResponseEntity.ok(new ItemRequest(updated));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:news')")
    public ResponseEntity<Item> delete(@PathVariable("id") Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build() ;
    }
}
