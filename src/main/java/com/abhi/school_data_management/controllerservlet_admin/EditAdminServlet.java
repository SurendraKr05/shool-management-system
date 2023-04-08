package com.abhi.school_data_management.controllerservlet_admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Admin;
import com.abhi.school_data_management.service.AdminService;
import com.abhi.school_data_management.service.AdminServiceImp;

@WebServlet("/editadminurl")
public class EditAdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		AdminService service=new AdminServiceImp();
		Admin admin =new Admin();
		int id=Integer.parseInt(req.getParameter("id"));
		String aName=req.getParameter("name");
		String aEmail=req.getParameter("email");
		String apass=req.getParameter("pass");
		
	
		admin.setAdminName(aName);
		admin.setEmail(aEmail);
		admin.setPassword(apass);
		
		admin.setId(id);
		

		     service.updateAdmin(admin);
		     

		pw.println("<a href='home.html'>Home</a>");		
		pw.println("<br>");
		pw.println("<a href='adminList'>Admin List</a>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
