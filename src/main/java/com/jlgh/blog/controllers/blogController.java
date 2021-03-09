package com.jlgh.blog.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jlgh.blog.repositories.BlogRepository;
import com.jlgh.blog.entities.Post;

import java.util.List;

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
        System.out.println("showAll request");

        List<Post> posts = this.blogRepository.findAll();
        return posts;
    }

    @CrossOrigin
    @PostMapping(value = "/insertPost")
    public String createPost(@RequestBody Post post) throws JsonProcessingException {
        System.out.println("insertNew request");
        System.out.println(post);

        post.setTime();
        this.blogRepository.insert(post);
        return "Succesfully added -" + post.title +"- to database";
    }

}

