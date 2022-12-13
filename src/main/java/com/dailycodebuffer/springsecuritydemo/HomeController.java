package com.dailycodebuffer.springsecuritydemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dailycodebuffer.springsecuritydemo.models.ContentModel;

@RestController

public class HomeController {
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ContentService contentService;

	@GetMapping("/test")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/fragments/sidebar.html");
		return modelAndView;
	}

	@GetMapping("/questions/{pathVariable}")
	public ModelAndView questions(@PathVariable String pathVariable) {
		// pass url to database to get the page content
		ContentModel contentModel = contentService.getContent(pathVariable);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/website/index.html");
		modelAndView.addObject("content", contentModel);
		// return the view with the data
		return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		return modelAndView;
	}

	@GetMapping("/content")
	public ModelAndView content() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/website/index.html");
		return modelAndView;
	}

	@GetMapping("/home")
	public String home() {
		return "This is Home Page";
	}

	@GetMapping("/admin")
	public String admin() {
		return "This is Admin Page";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		return modelAndView;
	}

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		return modelAndView;
	}

	@RequestMapping(value = "/adduser", method = { RequestMethod.POST })
	public ModelAndView addUser(@RequestParam Map<String, String> auth) {
		String username = auth.get("username");
		String password = auth.get("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("USER");
		userDetailsService.createUser(user);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		return modelAndView;

	}

}
