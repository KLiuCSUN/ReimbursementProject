package com.broovin.servlets;
import com.broovin.beans.User;
import com.broovin.dao.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SystemDAO dao = new SystemDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("user");
			System.out.println(username);
			String password = request.getParameter("pass");
			System.out.println(password);
			String isManager = request.getParameter("managerStatus");
			boolean user = false;
			try {
				user = dao.userLogin(username, password);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(user) {
				out.write("true");
			} else {
				out.write("false");
			}
	}
}