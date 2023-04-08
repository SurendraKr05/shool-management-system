package com.abhi.school_data_management.controllerservlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;
import com.abhi.school_data_management.util.ConnectionUtil;
@WebServlet("/getid")
public class GetDataUsingIdServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
			pw.println("<center><h1><div>Student</div></h1></center>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr>");
			pw.println("<th>Id</th>");
			pw.println("<th>Name</th>");
			pw.println("<th>Email</th>");
			pw.println("<th>Std</th>");
			pw.println("<th>Sec</th>");	
			pw.println("<th>OverAllPercentage</th>");
			pw.println("<th>Gender</th>");
			pw.println("<th>ParentContact</th>");
			pw.println("<th>Remarks</th>");
			pw.println("<th>Address</th>");
			StudentService service=new StudentServiceImp(); 
			Student student=new Student();
			int id=Integer.parseInt(req.getParameter("id"));
			 Student std=service.getStudentById(id);
				pw.println("<tr>");
				pw.println("<td>" + std.getId() + "</td>");
				pw.println("<td>" + std.getName() + "</td>");
				pw.println("<td>" + std.getEmail() + "</td>");
				pw.println("<td>" +	std.getStd() + "</td>");
				pw.println("<td>" + std.getSec() + "</td>");
				pw.println("<td>" + std.getOverAllPercentage() + "</td>");
				pw.println("<td>" + std.getGender() + "</td>");
				pw.println("<td>" + std.getParentContact() + "</td>");
				pw.println("<td>" + std.getRemarks() + "</td>");
				pw.println("<td>" + std.getAddress() + "</td>");

				pw.println("</tr>");
			
			pw.println("</table>");
		
		pw.println("<a href='home.html'>Home</a>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
