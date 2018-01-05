package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.TuitionDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("working");
		String message;
		String username = request.getParameter("email");
		String password = request.getParameter("pwd");
		int x;
		x = TuitionDAO.login(username, password);
		if (x>0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", x);
			session.setAttribute("email", username);
			response.sendRedirect("home.html");	
			
		}
		else {
			message="invalid login";
			response.setContentType("text/plain");
	        response.setContentLength(message.length());
	        response.getWriter().append(message);
	       /* PrintWriter out = response.getWriter();
	        out.println(message);
	        System.out.println("working?");
	        out.close();
	        out.flush();*/
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
