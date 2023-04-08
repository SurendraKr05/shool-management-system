package com.abhi.school_data_management.controllerservlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;

@WebServlet("/std1Save")
public class SaveDataServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		StudentService service=new StudentServiceImp();
    	Student student =new Student();
       
        	student.setName(req.getParameter("name"));
        	student.setEmail(req.getParameter("email"));
        	student.setStd(req.getParameter("std"));
        	student.setSec(req.getParameter("sec"));
        	student.setOverAllPercentage(req.getParameter("perc"));
        	student.setGender(req.getParameter("gender"));
        	student.setParentContact(req.getParameter("pcontact"));
        	student.setRemarks(req.getParameter("remarks"));
        	student.setAddress(req.getParameter("address"));
        	student.setPassword(req.getParameter("pass"));
        	String count = service.saveStudent(student);
        	
        	
        	
        	res.setContentType("text/html");
 	        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");	
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count!=null) {
                pw.println("<h2 class='bg-primary text-light text-center'>Record Saved Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Saved</h2>");
            }
       
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("&nbsp; &nbsp;");
        pw.println("<a href='stdList'><button class='btn btn-outline-success'>Show Student</button></a>");
        pw.println("</div>");
        pw.close();


		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
