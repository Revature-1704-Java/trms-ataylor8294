package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.TuitionDAO;

/**
 * Servlet implementation class CreateReimburse
 */
public class CreateReimburse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		if (sess!=null) {
			int x = (int) sess.getAttribute("id");
			System.out.println(x);
			
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
			if (sess!=null) {
				int x = (int) sess.getAttribute("id");
				String des = (String) request.getParameter("des");
				String loc = (String) request.getParameter("location");
				String cost   =  request.getParameter("cost");
				int costs = Integer.parseInt(cost);
				String type = (String) request.getParameter("type");
				int types = Integer.parseInt(type);
				System.out.println(x+" "+des + " "+loc +" "+costs+" "+types);
				try {
					TuitionDAO.createReimburse(x, des, loc, costs, types);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("home.html");
				}
			
			else {
				response.sendRedirect("index.html");
			}
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
