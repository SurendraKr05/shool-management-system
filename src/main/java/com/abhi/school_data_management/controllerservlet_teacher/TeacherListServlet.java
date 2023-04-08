package com.abhi.school_data_management.controllerservlet_teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.service.TeacherService;
import com.abhi.school_data_management.service.TeacherServiceImp;
import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;
@WebServlet("/teacherList")
public class TeacherListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		TeacherService serviceTeacher=new TeacherServiceImp();
		List<Teacher> teacher=serviceTeacher.getAllTeacher();
		try  {
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
//			pw.println("<th>Edit</th>");
//			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			for(Teacher teach:teacher) {
				pw.println("<tr>");
				pw.println("<td>" + teach.getId() + "</td>");
				pw.println("<td>" + teach.getName() + "</td>");
				pw.println("<td>" + teach.getEmail() + "</td>");
				pw.println("<td>" + teach.getContact() + "</td>");
				pw.println("<td>" + teach.getSubject() + "</td>");
				pw.println("<td>" + teach.getClassTeacher() + "</td>");
				pw.println("<td>" + teach.getSal() + "</td>");
				pw.println("<td>" + teach.getAddress() + "</td>");
				//pw.println("<td>" + rs.getString(9) + "</td>");
//				pw.println("<td><a href='#editScreen?id=" + teach.getId() + "'>Edit</a></td>");
//				pw.println("<td><a href='#deleteurl?id=" + teach.getId() + "'>Delete</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "/<h1>");
		}
	//	pw.println("<a href='home.html'>Home</a>");
	
//===========================================================/===================		
		resp.setContentType("text/html");

		StudentService service=new StudentServiceImp();
		resp.setContentType("text/html");
		List<Student> st=service.getAllStudent();
		try {
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
			pw.println("<th>Address</th>");
			pw.println("<th>Remarks</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			for(Student std:st)
			{
				pw.println("<tr>");
				pw.println("<td>" + std.getId() + "</td>");
				pw.println("<td>" + std.getName() + "</td>");
				pw.println("<td>" + std.getEmail() + "</td>");
				pw.println("<td>" + std.getStd() + "</td>");
				pw.println("<td>" + std.getSec() + "</td>");
				
				pw.println("<td>" + std.getOverAllPercentage() + "</td>");
				pw.println("<td>" + std.getGender() + "</td>");
				pw.println("<td>" + std.getParentContact() + "</td>");
				
				
				pw.println("<td>" + std.getAddress() + "</td>");
				pw.println("<td>" + std.getRemarks() + "</td>");
			pw.println("<td><a href='editScreen?id=" + std.getId() + "'>Edit</a></td>");
			pw.println("<td><a href='deleteurl?id=" + std.getId() + "'>Delete</a></td>");

				pw.println("</tr>");
			}
			pw.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "/<h1>");
		}
		pw.println("<a href='home.html'>Home</a>");

		
		//================================================================================
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
