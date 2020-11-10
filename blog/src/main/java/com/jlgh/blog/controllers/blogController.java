package com.jlgh.blog.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jlgh.blog.repositories.BlogRepository;
import com.jlgh.blog.entities.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
////
@RestController
@RequestMapping("/posts")
public class blogController {

    @Autowired
    public BlogRepository blogRepository;

    public blogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @CrossOrigin
    @GetMapping(value = "/showAll")
    public List<Post> getAllPosts() {
        List<Post> posts = this.blogRepository.findAll();
        return posts;
    }

    @CrossOrigin
    @PostMapping("/insert")
    public String createPost(@RequestBody Post post) throws JsonProcessingException {
        post.setTime();
        this.blogRepository.insert(post);
        return "Succesfully added -" + post.title +"- to database";
    }

}

