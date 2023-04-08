package com.abhi.school_data_management.controllerservlet_admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abhi.school_data_management.dto.Admin;
import com.abhi.school_data_management.service.AdminService;
import com.abhi.school_data_management.service.AdminServiceImp;
import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.service.TeacherService;
import com.abhi.school_data_management.service.TeacherServiceImp;
@WebServlet("/adminList")
public class AdminListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		AdminService service=new AdminServiceImp();
		resp.setContentType("text/html");
		List<Admin> admin=service.getAllAdmin();

		try {
			pw.println("<center><h1><div>Admin</div></h1></center>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr>");
			pw.println("<th>Id</th>");
			pw.println("<th>Name</th>");
			pw.println("<th>Email</th>");
			pw.println("<th>Password</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			for(Admin ad:admin){
				pw.println("<tr>");
				pw.println("<td>" + ad.getId() + "</td>");
				pw.println("<td>" + ad.getAdminName() + "</td>");
				pw.println("<td>" + ad.getEmail() + "</td>");
				pw.println("<td>" + ad.getPassword() + "</td>");
				pw.println("<td><a href='editAdminScreen?id=" + ad.getId() + "'>Edit</a></td>");
				pw.println("<td><a href='#deleteurl?id=" + ad.getId() + "'>Delete</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "/<h1>");
		}
//		pw.println("<a href='home.html'>Home</a>");
		
//===================================================================================
		
		TeacherService servicet=new TeacherServiceImp();
		resp.setContentType("text/html");
		List<Teacher> teacher=servicet.getAllTeacher();
		
			try {
				pw.println("<center><h1><div>Teacher</div></h1></center>");
				pw.println("<table border='1' align='center'>");
				pw.println("<tr>");
				pw.println("<th>Id</th>");
				pw.println("<th>Name</th>");
				pw.println("<th>Email</th>");
				pw.println("<th>Contact</th>");
				pw.println("<th>Subject</th>");	
				pw.println("<th>Class Teacher</th>");
				pw.println("<th>Salary</th>");
				pw.println("<th>Address</th>");		
				pw.println("<th>Edit</th>");
				pw.println("<th>Delete</th>");
				pw.println("</tr>");
				for(Teacher tech:teacher) {
					pw.println("<tr>");
					pw.println("<td>" + tech.getId() + "</td>");
					pw.println("<td>" + tech.getName() + "</td>");
					pw.println("<td>" + tech.getEmail() + "</td>");
					pw.println("<td>" + tech.getContact() + "</td>");
					pw.println("<td>" + tech.getSubject() + "</td>");
					pw.println("<td>" + tech.getClassTeacher() + "</td>");
					pw.println("<td>" + tech.getSal() + "</td>");
					pw.println("<td>" + tech.getAddress() + "</td>");
					//pw.println("<td>" + rs.getString(9) + "</td>");
					pw.println("<td><a href='editScreenTeacher?id=" + tech.getId() + "'>Edit</a></td>");
					pw.println("<td><a href='#deleteurl?id=" + tech.getId() + "'>Delete</a></td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("<h1>" + e.getMessage() + "/<h1>");
			}
			pw.println("<a href='home.html'>Home</a>");

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}




