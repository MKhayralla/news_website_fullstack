package com.homain.interview.task.news.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homain.interview.task.news.item.Item;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Long id ;
    private String name ;
    private String image ;
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items ;
    public Category(){}
    public Category(String name, String image) {
        this.name = name;
        this.image = image ;
    }
    public Long getId(){
        return id ;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<Item> getItems() {
        return items;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", image=" + image + ", name=" + name + "]";
    }
    
}
