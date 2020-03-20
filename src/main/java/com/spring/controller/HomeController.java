package com.spring.controller;


import com.spring.model.ProductModel;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping(value = {"/home"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home-html");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public ModelAndView detail(@RequestParam(name = "id")Long id,@RequestParam(name = "name")String dayLaTen) {
        ModelAndView modelAndView = new ModelAndView(("detail-product"));
        System.out.println(dayLaTen);
        ProductModel product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;

    }
}
