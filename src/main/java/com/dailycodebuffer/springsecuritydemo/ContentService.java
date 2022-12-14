package com.dailycodebuffer.springsecuritydemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.springsecuritydemo.models.ContentModel;
import com.dailycodebuffer.springsecuritydemo.repositories.ContentRepository;

@Service
public class ContentService {
	@Autowired
	private ContentRepository contentrepository;

	public ContentModel getContent(String path) {
		ContentModel contentModel=null;
		try {
		 contentModel= contentrepository.findByUrl(path);
		}catch(Exception e) {
			throw new IllegalArgumentException("Page not found");
		}
		return contentModel;

	}
	
	public List<ContentModel> getAll() {
		return contentrepository.findAll();
		

	}
	
	public void saveContent(ContentModel contentModel) {
		contentrepository.save(contentModel);
		

	}
	
	public void delete(Long id) {
		Optional<ContentModel> contentModel=contentrepository.findById(id);
		if(contentModel!=null) {
			contentrepository.deleteById(id);
		}
		
	}
}
