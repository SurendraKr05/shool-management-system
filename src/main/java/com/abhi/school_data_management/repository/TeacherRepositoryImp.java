package com.abhi.school_data_management.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.util.ConnectionUtil;

public class TeacherRepositoryImp implements TeacherRepository{

	@Override
	public String saveTeacher(Teacher teacher) {
		Connection con=ConnectionUtil.getConnection();
		String sql="INSERT INTO TEACHER(name,email,contact,subject,class_teacher,sal,address,password)VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, teacher.getName());
			pst.setString(2, teacher.getEmail());
			pst.setString(3, teacher.getContact());
			pst.setString(4, teacher.getSubject());
			pst.setString(5, teacher.getClassTeacher());
			pst.setString(6, teacher.getSal());
			pst.setString(7, teacher.getAddress());
			pst.setString(8, teacher.getPassword());
			
		int res=pst.executeUpdate();
		con.close();
		return res+" row added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher teacherLogin(String email, String password) {
		Connection con=ConnectionUtil.getConnection();
		Teacher teacher=null;
		String sql="SELECT * FROM teacher WHERE email=? AND password=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet resultset=pst.executeQuery();
			if(resultset.next())
			{
				teacher=new Teacher();
				teacher.setId(resultset.getInt(1));
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));	
			}
			con.close();
			return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher getTeacherById(int id) {
		Teacher teacher=null;
		Connection con =ConnectionUtil.getConnection();
		String sql="select * from teacher where id =?";	
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet resultset=pst.executeQuery();
		while(resultset.next()) {
			teacher = new Teacher();	
			teacher.setId(resultset.getInt(1));
			teacher.setName(resultset.getString(2));
			teacher.setEmail(resultset.getString(3));
			teacher.setContact(resultset.getString(4));
			teacher.setSubject(resultset.getString(5));
			teacher.setClassTeacher(resultset.getString(6));
			teacher.setSal(resultset.getString(7));
			teacher.setAddress(resultset.getString(8));
			teacher.setPassword(resultset.getString(9));
		}
			con.close();
			return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher deleteTeacher(int id) {
		Teacher teacher=new Teacher();
		Connection con =ConnectionUtil.getConnection();
		String sqlQuery="delete from teacher where id=?";	
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sqlQuery);
				pst.setInt(1, id);
				pst.executeUpdate();
			
			con.close();
			return teacher;
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Connection con =ConnectionUtil.getConnection();
		String sqlQuery="update teacher set name=?,email=?,contact=?,subject=?,class_teacher=?,sal=?,address=?,password=? where id=?";	
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sqlQuery);
				pst.setString(1, teacher.getName());
				pst.setString(2, teacher.getEmail());
				pst.setString(3, teacher.getContact());
				pst.setString(4, teacher.getSubject());
				pst.setString(5, teacher.getClassTeacher());
				pst.setString(6, teacher.getSal());
				pst.setString(7, teacher.getAddress());
				pst.setString(8, teacher.getPassword());
				pst.setInt(9, teacher.getId());
				pst.executeUpdate();			
			con.close();
			return teacher;
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
		Connection con =ConnectionUtil.getConnection();
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher where subject =?";	
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, subject);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Teacher teacher = new Teacher();	
				teacher.setId(resultset.getInt(1));			
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));
				list.add(teacher);
			}
				
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Teacher> getClassTeacher(String classTeacher) {
		Connection con =ConnectionUtil.getConnection();
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher where class_teacher=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, classTeacher);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Teacher teacher = new Teacher();	
				teacher.setId(resultset.getInt(1));			
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));
				list.add(teacher);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public List<Teacher> getTeacherByContact(String contact) {
		Connection con =ConnectionUtil.getConnection();
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher where contact=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contact);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Teacher teacher = new Teacher();	
				teacher.setId(resultset.getInt(1));			
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));
				list.add(teacher);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySal(String sal) {
		Connection con =ConnectionUtil.getConnection();
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher where sal=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sal);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Teacher teacher = new Teacher();	
				teacher.setId(resultset.getInt(1));			
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));
				list.add(teacher);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		Connection con =ConnectionUtil.getConnection();
		List<Teacher> list=new ArrayList<Teacher>();
		
		String sqlQuery="select * from teacher";
	
			try {
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Teacher teacher = new Teacher();	
				teacher.setId(resultset.getInt(1));			
				teacher.setName(resultset.getString(2));
				teacher.setEmail(resultset.getString(3));
				teacher.setContact(resultset.getString(4));
				teacher.setSubject(resultset.getString(5));
				teacher.setClassTeacher(resultset.getString(6));
				teacher.setSal(resultset.getString(7));
				teacher.setAddress(resultset.getString(8));
				teacher.setPassword(resultset.getString(9));

				list.add(teacher);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

}
