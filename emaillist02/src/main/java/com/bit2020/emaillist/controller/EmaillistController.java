package com.bit2020.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.emaillist.vo.EmaillistVo;


public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("a");
		
		if("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			EmaillistVo vo = new EmaillistVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookDao().insert(vo);
			response.sendRedirect(request.getContextPath() + "/gb");
		} else if("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);			
		} else if("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			new GuestbookDao().delete(Long.parseLong(no), password);
			response.sendRedirect(request.getContextPath() + "/gb");
		} else {
			/* list */
			List<GuestbookVo> list = new GuestbookDao().findAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
