package com.controller;


import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/c")
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/category")
    public String getProducts() {

        return categoryRepository.queryCategory().toString();
        
    }

}
