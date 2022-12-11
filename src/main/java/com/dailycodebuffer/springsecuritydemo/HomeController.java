package com.dailycodebuffer.springsecuritydemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomeController {
@Autowired
private CustomUserDetailsService userDetailsService;
@Autowired
private PasswordEncoder passwordEncoder;
	@GetMapping("/")
	public ModelAndView index () {
		System.out.print("boolean");
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index.html");
	    return modelAndView;
    }
	
    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }

    @GetMapping("/login")
    public ModelAndView login(){
    	System.out.print("login called");
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login.html");
	    return modelAndView;
    }
    

    @GetMapping("/register")
    public ModelAndView register(){
    	System.out.print("register called");
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("register.html");
	    return modelAndView;
    }
   @RequestMapping(value = "/adduser", method = {RequestMethod.POST})
    public void addUser(@RequestParam Map<String, String> auth){
	   String username=auth.get("username");
	   String password=auth.get("password");
	   
	   User user=new User();
	   user.setUsername(username);
	   user.setPassword(passwordEncoder.encode(password));
	   user.setRole("USER");
    	userDetailsService.createUser(user);
    	
    }
    
}
