package com.homain.interview.task.news.config;

import com.homain.interview.task.news.category.Category;
import com.homain.interview.task.news.category.CategoryRepo;
import com.homain.interview.task.news.item.Item;
import com.homain.interview.task.news.item.ItemRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Populate {
    @Bean
    CommandLineRunner config(ItemRepo itemsRepo, CategoryRepo categoriesRepo) {
        return args -> {
            Category politics = new Category("Politics", "https://thumbs.dreamstime.com/b/black-solid-icon-speech-politics-leader-black-solid-icon-speech-politician-logo-politics-leader-146772569.jpg") ;
            Category sport = new Category("Sport", "https://st2.depositphotos.com/4840515/7191/i/950/depositphotos_71918941-stock-photo-silhouettes-figures-of-athletes.jpg") ;
            Category health = new Category("Health", "https://thumbs.dreamstime.com/b/heart-icon-vector-health-perfect-love-symbol-emblem-isolated-white-background-shadow-flat-style-graphic-web-design-127436803.jpg") ;
            Category entertainment = new Category("Entertainment", "https://comps.canstockphoto.com/entertainment-icon-set-image_csp52190573.jpg") ;
            categoriesRepo.saveAll(List.of(
                politics,
                sport,
                health,
                entertainment
            ));
            Item item1 = new Item("Biden launches federal effort to respond to Texas law as he faces pressure to protect abortion",
                "description\ndescription\ndescription",
                "https://cdn.cnn.com/cnnnext/dam/assets/200304111019-01-abortion-protests-supreme-court-medium-plus-169.jpg",
                politics) ;
            Item item2 = new Item("England won 4-0 over host Hungary",
                "description\ndescription\ndescription",
                "https://e0.365dm.com/21/09/512x512/skysports-raheem-sterling-england_5499010.jpg",
                sport) ;
            Item item3 = new Item("Coronavirus live news: Bulgaria tightens restrictions ahead of expected surge; further 178 UK deaths reported — as it happened",
                "description\ndescription\ndescription",
                "https://i.guim.co.uk/img/media/d0b6a615cca747e8cbcf9acb7bfcafd9a1143943/0_350_5343_3205/master/5343.jpg?width=620&quality=85&auto=format&fit=max&s=674796953dacebf28c607f5280a7a0a7",
                health) ;
            Item item4 = new Item("Film: More people needed to work with Hollywood stars",
                "description\ndescription\ndescription",
                "https://ichef.bbci.co.uk/news/976/cpsprodpb/A02E/production/_120360014_gavinandstacey.jpg",
                entertainment) ;
            itemsRepo.saveAll(List.of(
                item1,
                item2,
                item3,
                item4
            )) ;
        } ;
    }
}
