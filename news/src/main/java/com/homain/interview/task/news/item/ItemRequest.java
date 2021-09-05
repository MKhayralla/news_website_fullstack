package com.homain.interview.task.news.item;


public class ItemRequest {
    private String title ;
    private String description ;
    private String image ;
    private Long category ;
    private Long id;
    public ItemRequest() {}
    public ItemRequest(String title, String description, String image, Long category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
    }
    public ItemRequest(String title, String description, String image, String category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = Long.valueOf(category);
    }
    public ItemRequest(Item item) {
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.image = item.getImage();
        this.category = item.getCategory().getId();
        this.id = item.getId() ;
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
    public Long getCategory() {
        return category;
    }
    public void setCategory(Long category) {
        this.category = category;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
        
}
