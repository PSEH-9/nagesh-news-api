package com.sapient.exercise.sapientassignment.controller;


import com.sapient.exercise.sapientassignment.model.ResponceExample;
import com.sapient.exercise.sapientassignment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Welcome";
    }

    @GetMapping(value = "/api/Categorizednews/{country}/{category}")
    public List<ResponceExample> sendCategorizedUpdate(@PathVariable String country, @PathVariable String category) throws ParseException, IOException {
        return newsService.sendCategoryUpdate(country,category);
    }

    @GetMapping(value = "/api/Sourcednews/{country}/{source123}")
    public List<ResponceExample> sendSourcedUpdate(@PathVariable String country, @PathVariable String source123) throws ParseException, IOException {
        return newsService.sendSourcedNews(country,source123);
    }

    @GetMapping(value = "/api/news/{country}/{category}/{source123}")
    public List<ResponceExample> sendRefinedUpdate(@PathVariable String country, @PathVariable String category, @PathVariable String source123) throws ParseException, IOException {
        return newsService.sendRefinedUpdate(country,category,source123);
    }



}
