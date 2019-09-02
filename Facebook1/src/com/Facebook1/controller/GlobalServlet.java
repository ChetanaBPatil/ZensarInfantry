package com.Facebook1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Facebook1.entity.FacebookEmployee;
import com.Facebook1.service.FacebookService;
import com.Facebook1.service.FacebookServiceInterface;


public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    out.println("<html><body>");
		
		String option=request.getParameter("ac");
		
		if(option.equals("register")) {
			//here name,pass,email,address are the name of html boxes
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		//now servlet want to transfer above data to service so it should transfer in form of object bcoz of DTO
		//design pattern
		//object of ? answer is entity now create entity FacebookEmployee and set all values
		FacebookEmployee fe=new FacebookEmployee();
		fe.setName(name);
		fe.setPass(password);
		fe.setEmail(email);
		fe.setAddress(address);
		//now pass fe objecr to sevice layer how ? via object of service layer so create object using factory design pattern and maintain low coupling via interfACE
		
		FacebookServiceInterface fs=FacebookService.createServiceObject(); //createServiceObject() is factory()
		
		int i=fs.createProfile(fe);
		
		if(i>0) {
			out.println("profile created <a href=login.html>Login</a>");
			
		}
		else {
			out.println("profile not created");
			
		}
		}
       if(option.equals("login")) {
			
		}
       if(option.equals("timeline")) {
			
		}
       out.println("</body><html>");
	}

}
