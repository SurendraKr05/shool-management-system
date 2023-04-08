package com.abhi.school_data_management.controllerservlet_teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.service.TeacherService;
import com.abhi.school_data_management.service.TeacherServiceImp;
@WebServlet("/editScreenTeacher")
public class EditScreenTeacherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TeacherService service=new TeacherServiceImp();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));

		try  {

			Teacher techiddec=service.getTeacherById(id);//getStudentById(id);
			out.println("<form action='editteacherurl?id=" + id + "'method='post'>");
			out.println("<table align='center'>");
			out.println("<tr>");
//			out.println("<td>Student Id</td>");
//			out.println("<td><input type='text' name='id' value='" + stdiddec.getId() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Teacher Name</td>");
			out.println("<td><input type='text' name='name' value='" + techiddec.getName() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type='text' name='email' value='" + techiddec.getEmail() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Class Teacher</td>");
			out.println("<td><input type='text' name='ct' value='" + techiddec.getClassTeacher() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Contact</td>");
			out.println("<td><input type='text' name='contact' value='" +techiddec.getContact() + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Salary</td>");
			out.println("<td><input type='text' name='sal' value='" +techiddec.getSal() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Subject</td>");
			out.println("<td><input type='text' name='sub' value='" +techiddec.getSubject() + "'></td>");
			out.println("</tr>");
				
			out.println("<td>Address</td>");
			out.println("<td><input type='text' name='add' value='" +techiddec.getAddress() + "'></td>");
			out.println("</tr>");
			out.println("<td>Password</td>");
			out.println("<td><input type='text' name='pass' value='" +techiddec.getPassword() + "'></td>");
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
