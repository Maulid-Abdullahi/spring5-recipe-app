package com.spring.Recipe.controllers;

import com.spring.Recipe.domain.Category;
import com.spring.Recipe.domain.UnitOfMeasure;
import com.spring.Recipe.repositories.CategoryRepository;
import com.spring.Recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Kenyan");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("TeaSpoon");
        System.out.println("Category Id Is: " + categoryOptional.get().getId());
        System.out.println("UnitOfMeasure Id Is: "+ unitOfMeasureOptional.get().getId());

        return "index";
    }

}
