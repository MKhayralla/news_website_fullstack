package com.homain.interview.task.news.item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.homain.interview.task.news.category.Category;
import com.homain.interview.task.news.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemService {
    @Autowired
    private ItemRepo itemsRepo ;
    @Autowired
    private CategoryService categoriesService ;
    /*@Autowired
    public ItemService(ItemRepo itemsRepo){
        this.itemsRepo = itemsRepo ;
    }
    */
    public List<ItemRequest> getNews() {
        return itemsRepo.findAll()
        .parallelStream()
        .map(item -> new ItemRequest(item))
        .collect(Collectors.toList()) ;
    }
    public Optional<Item> getItem(Long id) {
        return itemsRepo.findById(id) ;
    }
    public Item createItem(ItemRequest item) {
        Category c = categoriesService.findCategory(item.getCategory()).get() ;
        return itemsRepo.save(new Item(
            item.getTitle(),
            item.getDescription(),
            item.getImage(),
            c
        )) ;
    }
    public Item updateItem(Long id , Item item) {
        return itemsRepo.findById(id).map(
            oldVal -> {
                oldVal.setTitle(item.getTitle()) ;
                oldVal.setDescription(item.getDescription());
                oldVal.setImage(item.getImage());
                oldVal.setCategory(item.getCategory());
                return itemsRepo.save(oldVal) ;
            }
        )
        .orElseGet(() -> itemsRepo.save(item)) ;
    }
    public void deleteItem(Long id) {
        itemsRepo.deleteById(id);
    }
}
