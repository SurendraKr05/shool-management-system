package com.abhi.school_data_management.controllerservlet_student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;
@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
	//private static final String query = "select * from Student where id =?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService service=new StudentServiceImp();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));

		try  {

			Student stdiddec=service.getStudentById(id);
			out.println("<form action='editurl?id=" + id + "'method='post'>");
			out.println("<table align='center'>");
			out.println("<tr>");
//			out.println("<td>Student Id</td>");
//			out.println("<td><input type='text' name='id' value='" + stdiddec.getId() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Student Name</td>");
			out.println("<td><input type='text' name='name' value='" + stdiddec.getName() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type='text' name='email' value='" + stdiddec.getEmail() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Class</td>");
			out.println("<td><input type='text' name='std' value='" + stdiddec.getStd() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Section</td>");
			out.println("<td><input type='text' name='sec' value='" +stdiddec.getSec() + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>OverAllPercentage</td>");
			out.println("<td><input type='text' name='perc' value='" +stdiddec.getOverAllPercentage() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Gender</td>");
			out.println("<td><input type='text' name='gender' value='" +stdiddec.getGender() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Parent Contact</td>");
			out.println("<td><input type='text' name='pcontact' value='" +stdiddec.getParentContact() + "'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Remarks</td>");
			out.println("<td><input type='text' name='remarks' value='" +stdiddec.getRemarks() + "'></td>");
			out.println("</tr>");
			
			out.println("<td>Address</td>");
			out.println("<td><input type='text' name='address' value='" +stdiddec.getAddress() + "'></td>");
			out.println("</tr>");
			out.println("<td>Password</td>");
			out.println("<td><input type='text' name='pass' value='" +stdiddec.getPassword() + "'></td>");
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
