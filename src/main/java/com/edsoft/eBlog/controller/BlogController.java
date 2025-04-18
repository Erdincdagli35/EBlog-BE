package com.edsoft.eBlog.controller;


import com.edsoft.eBlog.model.Blog;
import com.edsoft.eBlog.service.BlogService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@EnableAutoConfiguration
@CrossOrigin
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.create(blog));
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAll() {
        return ResponseEntity.ok(blogService.getAll());
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Long> delete(@PathVariable Long blogId ) {
        return ResponseEntity.ok(blogService.delete(blogId));
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> getById(@PathVariable Long blogId ) {
        return ResponseEntity.ok(blogService.getById(blogId));
    }

    @PutMapping
    public ResponseEntity<Blog> edit(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.edit(blog));
    }
}
