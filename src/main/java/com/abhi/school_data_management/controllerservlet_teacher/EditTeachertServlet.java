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
@WebServlet("/editteacherurl")
public class EditTeachertServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			
			TeacherService service=new TeacherServiceImp();
			Teacher teacher =new Teacher();
			int id=Integer.parseInt(req.getParameter("id"));
			String tName=req.getParameter("name");
			String tEmail=req.getParameter("email");
			String tCTeacher=req.getParameter("ct");
			String tSubject=req.getParameter("sub");
			String tContact=req.getParameter("contact");
			String tsalary=req.getParameter("sal");
			String tAddress=req.getParameter("add");
			String tpass=req.getParameter("pass");
			
		
			teacher.setName(tName);
			teacher.setEmail(tEmail);
			teacher.setClassTeacher(tCTeacher);
			teacher.setSubject(tSubject);
			teacher.setContact(tContact);
			teacher.setSal(tsalary);
			teacher.setAddress(tAddress);
			teacher.setPassword(tpass);
			
			teacher.setId(id);
			

			     service.updateTeacher(teacher);
			     

			pw.println("<a href='home.html'>Home</a>");		
			pw.println("<br>");
			pw.println("<a href='adminList'>Teacher List</a>");
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}
