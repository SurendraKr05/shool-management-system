package com.abhi.school_data_management.controllerservlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;

@WebServlet("/stdList")
public class StudentListServlet extends HttpServlet{	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		StudentService service=new StudentServiceImp();
		resp.setContentType("text/html");
		List<Student> st=service.getAllStudent();
		try {
			out.println("<center><h1><div>Student</div></h1></center>");
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Std</th>");
			out.println("<th>Sec</th>");	
			out.println("<th>OverAllPercentage</th>");
			out.println("<th>Gender</th>");
			out.println("<th>ParentContact</th>");
			out.println("<th>Address</th>");
			out.println("<th>Remarks</th>");
//			out.println("<th>Edit</th>");
//			out.println("<th>Delete</th>");
			out.println("</tr>");
			for(Student std:st)
			{
				out.println("<tr>");
				out.println("<td>" + std.getId() + "</td>");
				out.println("<td>" + std.getName() + "</td>");
				out.println("<td>" + std.getEmail() + "</td>");
				out.println("<td>" + std.getStd() + "</td>");
				out.println("<td>" + std.getSec() + "</td>");				
				out.println("<td>" + std.getOverAllPercentage() + "</td>");
				out.println("<td>" + std.getGender() + "</td>");
				out.println("<td>" + std.getParentContact() + "</td>");
				out.println("<td>" + std.getAddress() + "</td>");
				out.println("<td>" + std.getRemarks() + "</td>");
//			out.println("<td><a href='editScreen?id=" + std.getId() + "'>Edit</a></td>");
//			out.println("<td><a href='deleteurl?id=" + std.getId() + "'>Delete</a></td>");

				out.println("</tr>");
			}
			out.println("</table>");
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
