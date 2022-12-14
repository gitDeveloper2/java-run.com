package com.dailycodebuffer.springsecuritydemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dailycodebuffer.springsecuritydemo.models.ContentModel;

@RestController
public class AdminController {
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ContentService contentService;
	
	@GetMapping("/read")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ContentModel> list=new ArrayList<>();
		list.addAll(contentService.getAll());
		modelAndView.addObject("data",list);
		modelAndView.setViewName("/website/adminIndex.html");
		return modelAndView;
	}
	
	@GetMapping("/read/{pathVariable}")
	public ModelAndView read(@PathVariable String pathVariable) {
		// pass url to database to get the page content
		ContentModel contentModel = contentService.getContent(pathVariable);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/website/index.html");
		modelAndView.addObject("content", contentModel);
		// return the view with the data
		return modelAndView;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/fragments/sidebar.html");
		return modelAndView;
	}
	
	@GetMapping("/update")
	public ModelAndView update() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/fragments/sidebar.html");
		return modelAndView;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/fragments/sidebar.html");
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/fragments/sidebar.html");
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
