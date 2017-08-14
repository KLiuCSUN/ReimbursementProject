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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			String isManager = request.getParameter("managerSelect");
			out.write("<body onload='myFunction()'><a href='#' onclick='myFunction()'>Redirecting...Click here to continue if nothing happens</a></body>\n<script>function myFunction(){\n");
			boolean user = false;
			try {
				user = dao.userLogin(username, password, isManager);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(user) {
				out.write("sessionStorage.user='"+ username + "';\nsessionStorage.pass='"+password+"';\n");
				
				out.write("");
				if(isManager.equals("n")) {
					out.write("window.location.href = 'Employee.html';");
				}else {
					out.write("window.location.href = 'Manager.html';");
				}
				
			} else {
				out.write("sessionStorage.removeItem('user');sessionStorage.removeItem('pass');alert('USER DOES NOT EXIST OR PASSWORD INCORRECT.');");
				out.write("window.location.href = 'Index.html';");
			}
			out.write("\n}</script>");
	}
}