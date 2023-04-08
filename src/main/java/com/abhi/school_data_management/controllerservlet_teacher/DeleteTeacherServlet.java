package com.abhi.school_data_management.controllerservlet_teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.util.ConnectionUtil;

public class DeleteTeacherServlet extends HttpServlet{
	private static final String query = "delete from teacher where id=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		int id=Integer.parseInt(req.getParameter("id"));
		

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, id);
			
			int count=pst.executeUpdate();
			if(count==1)
			{
				pw.println("<h2> Record is Deleted Successfully </h2>");
			}
			else {
				pw.println("<h2>Record Not Delete Successfully </h2>");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1>"+se.getMessage()+"/<h1>");
		}catch(Exception e)
		{
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"/<h1>");
		}
		pw.println("<a href='home.html'>Home</a>");
		
		pw.println("<br>");
		pw.println("<a href='teacherList'>Teacher List</a>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
