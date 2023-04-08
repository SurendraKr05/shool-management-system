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
@WebServlet("/editAdminScreen")
public class EditScreenAdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminService service=new AdminServiceImp();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));

		try  {

			Admin stdiddec=service.getAdminById(id);
			out.println("<form action='editadminurl?id=" + id + "'method='post'>");
			out.println("<table align='center'>");
			out.println("<tr>");
//			out.println("<td>Student Id</td>");
//			out.println("<td><input type='text' name='id' value='" + stdiddec.getId() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Student Name</td>");
			out.println("<td><input type='text' name='name' value='" + stdiddec.getAdminName() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type='text' name='email' value='" + stdiddec.getEmail() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Password</td>");
			out.println("<td><input type='text' name='pass' value='" +stdiddec.getPassword() + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><input type='submit' value='Edit'></td>");
			out.println("<td><input type='reset' value='Cancel'></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h1>" + e.getMessage() + "/<h1>");
		}
		out.println("<a href='home.html'>Home</a>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
