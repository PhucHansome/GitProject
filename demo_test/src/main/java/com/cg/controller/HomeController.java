package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home/list");
        return modelAndView;
    }
}
