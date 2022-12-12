package com.dailycodebuffer.springsecuritydemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springsecuritydemo.models.ContentModel;
@Repository
public interface ContentRepository extends JpaRepository<ContentModel,Long>{
public ContentModel findByUrl(String path);
}
