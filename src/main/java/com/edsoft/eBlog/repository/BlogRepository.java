package com.edsoft.eBlog.repository;

import com.edsoft.eBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findOneById(Long id);
}
