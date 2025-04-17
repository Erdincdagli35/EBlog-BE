package com.edsoft.eBlog.service;

import com.edsoft.eBlog.model.Blog;
import com.edsoft.eBlog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Long delete(Long blogId) {
        blogRepository.delete(blogRepository.findOneById(blogId));
        return blogId;
    }

    public Blog edit(Blog blog) {
        Blog newBlog = blogRepository.findOneById(blog.getId());

        newBlog.setId(blog.getId());
        newBlog.setTitle(blog.getTitle());
        newBlog.setDescription(blog.getDescription());
        newBlog.setName(blog.getName());
        newBlog.setSurname(blog.getSurname());

        newBlog = blogRepository.save(newBlog);
        return newBlog;
    }

    public Blog getById(Long blogId) {
        return blogRepository.findOneById(blogId);
    }
}
