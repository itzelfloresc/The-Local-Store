package com.product;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CtrlProduct {

    @GetMapping
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<Category>();
        
        categories.add(new Category(1, "Lentes", "lts"));

        categories.add(new Category(2, "Relojes", "rljs"));

        return categories;
    }
}
