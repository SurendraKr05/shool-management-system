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
@WebServlet("/adminSave")
public class AdminSaveDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		AdminService service=new AdminServiceImp();
		Admin admin =new Admin();
       
			admin.setAdminName(req.getParameter("name"));
			admin.setEmail(req.getParameter("email"));
			admin.setPassword(req.getParameter("pass"));
        	String count = service.saveAdmin(admin);
        	
        	
        	
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
        pw.println("<a href='adminList'><button class='btn btn-outline-success'>Show Admins</button></a>");
        pw.println("</div>");
        pw.close();


		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
