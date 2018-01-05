package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimburse;
import com.revature.model.TuitionDAO;

/**
 * Servlet implementation class CreateView
 */
public class CreateView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess!=null) {
			int x = (int) sess.getAttribute("id");
			System.out.println(x);
			List<Reimburse> list = null;
			try {
				list = TuitionDAO.retrieveReimburse(x);
				if(list.isEmpty()) {
					String message="invalid login";
					response.setContentType("text/plain");
			        response.setContentLength(message.length());
			        response.getWriter().append(message);
				}
				else {
					ObjectMapper map = new ObjectMapper();
					String json ="";
					for (int i=0; i<list.size(); i++) {
						json += map.writeValueAsString(list.get(i));
					}
					System.out.print(json);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.print(json);
					out.flush();
					out.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list);
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		else {
			response.sendRedirect("");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method /tub
		doGet(request, response);
	}

}
