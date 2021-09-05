package com.homain.interview.task.news.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.homain.interview.task.news.category.Category;


@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(columnDefinition = "TEXT")
    private String title ;
    @Column(columnDefinition = "TEXT")
    private String description ;
    @Column(columnDefinition = "TEXT")
    private String image ;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category ;
    public Item() {}
    public Item(String title, String description, String image, Category category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category ;
    }
    public Long getId(){
        return id ;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Item [category=" + category.getName() + ", description=" + description + ", id=" + id + ", image=" + image
                + ", title=" + title + "]";
    }
    
    
}
