package com.abhi.school_data_management.controllerservlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;
import com.abhi.school_data_management.util.ConnectionUtil;
@WebServlet("/editurl")
public class EditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		StudentService service=new StudentServiceImp();
		Student student =new Student();
		int id=Integer.parseInt(req.getParameter("id"));
		String stdName=req.getParameter("name");
		String stdEmail=req.getParameter("email");
		String stdStd=req.getParameter("std");
		String stdSec=req.getParameter("sec");
		String stdOAap=req.getParameter("perc");
		String stdGender=req.getParameter("gender");
		String stdPContact=req.getParameter("pcontact");
		String stdRemark=req.getParameter("remarks");
		String stdAdd=req.getParameter("address");
		String pwd=req.getParameter("pass");
		
		
	
		student.setName(stdName);
		student.setEmail(stdEmail);
		student.setGender(stdGender);
		student.setOverAllPercentage(stdOAap);
		student.setParentContact(stdPContact);
		student.setSec(stdSec);
		student.setStd(stdStd);
		student.setRemarks(stdRemark);
		student.setAddress(stdAdd);
		student.setPassword(pwd);
		student.setId(id);
		

		     service.updateStudent(student);
		     

		pw.println("<a href='home.html'>Home</a>");		
		pw.println("<br>");
		pw.println("<a href='stdList'>Student List</a>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
