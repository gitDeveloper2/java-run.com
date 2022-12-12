package com.dailycodebuffer.springsecuritydemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessAuthenticationHandler implements AuthenticationSuccessHandler{
	public SuccessAuthenticationHandler(){

	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
	        HttpServletResponse response, Authentication auth) throws     IOException, ServletException {
	    HttpSession session = request.getSession(); 
	    CustomUserDetails user =   (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    
	    String redirect = ""; 
	    if(user != null){
	        session.setAttribute("username", user.getUsername());
	        if(user.getAuthorities().contains(new   SimpleGrantedAuthority("ADMIN")) 
	                || user.getAuthorities().contains(new   SimpleGrantedAuthority("SUPER_ADMIN")))
	            redirect = "/admin"; 
	        else if(user.getAuthorities().contains(new SimpleGrantedAuthority("USER")))
	            redirect = "/home"; 
	    }
	    if(redirect.isEmpty())
	        redirect = "/login"; 

	    response.sendRedirect(redirect); 
	}



	}
