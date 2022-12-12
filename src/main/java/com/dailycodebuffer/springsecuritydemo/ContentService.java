package com.dailycodebuffer.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.springsecuritydemo.models.ContentModel;
import com.dailycodebuffer.springsecuritydemo.repositories.ContentRepository;

@Service
public class ContentService {
	@Autowired
	private ContentRepository contentrepository;

	public ContentModel getContent(String path) {
		ContentModel contentModel = contentrepository.findByUrl(path);
		return contentModel;

	}
	
	public void saveContent(ContentModel contentModel) {
		contentrepository.save(contentModel);
		

	}
}
