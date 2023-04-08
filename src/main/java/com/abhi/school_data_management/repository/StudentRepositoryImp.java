package com.abhi.school_data_management.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.util.AppConstants;
import com.abhi.school_data_management.util.ConnectionUtil;

public class StudentRepositoryImp implements StudentRepository{
	@Override
	public Student studentLogin(String email, String password) {
		Connection con=ConnectionUtil.getConnection();
		Student student=null;
		String sql="SELECT * FROM STUDENT WHERE email=? AND password=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet resultset=pst.executeQuery();
			if(resultset.next())
			{
				student=new Student();
				student.setId(resultset.getInt(1));
				student.setName(resultset.getString(2));
				student.setEmail(resultset.getString(3));
				student.setStd(resultset.getString(4));
				student.setSec(resultset.getString(5));
				student.setOverAllPercentage(resultset.getString(6));
				student.setGender(resultset.getString(7));
				student.setParentContact(resultset.getString(8));
				student.setRemarks(resultset.getString(9));
				student.setAddress(resultset.getString(10));
				student.setPassword(resultset.getString(11));	
			}
			con.close();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveStudent(Student student) {
		Connection con= ConnectionUtil.getConnection();
		String sql="insert into student(name,email,std,sec,over_all_percentage,gender,parent_contact,remarks,address,password)values(?,?,?,?,?,?,?,?,?,?)";	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setString(2, student.getEmail());
			pst.setString(3, student.getStd());
			pst.setString(4, student.getSec());
			pst.setString(5, student.getOverAllPercentage());
			pst.setString(6, student.getGender());
			pst.setString(7, student.getParentContact());
			pst.setString(8, student.getRemarks());
			pst.setString(9, student.getAddress());
			pst.setString(10, student.getPassword());

		int res=pst.executeUpdate();
		con.close();
		return res+" row added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudentById(int id) {
		Student student=null;
		Connection con =ConnectionUtil.getConnection();
		String sql="select * from Student where id =?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet resultset=pst.executeQuery();
		while(resultset.next()) {
			student = new Student();	
			student.setId(resultset.getInt(1));
			student.setName(resultset.getString(2));
			student.setEmail(resultset.getString(3));
			student.setStd(resultset.getString(4));
			student.setSec(resultset.getString(5));
			student.setOverAllPercentage(resultset.getString(6));
			student.setGender(resultset.getString(7));
			student.setParentContact(resultset.getString(8));
			student.setRemarks(resultset.getString(9));
			student.setAddress(resultset.getString(10));
			student.setPassword(resultset.getString(11));
		}
			con.close();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student deleteStudent(int id) {
		Student student=new Student();
		
		Connection con =ConnectionUtil.getConnection();
		String sqlQuery="delete from student where id=?";
	
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sqlQuery);
				pst.setInt(1, id);
			int res=pst.executeUpdate();
			con.close();
			return student;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		Connection con=ConnectionUtil.getConnection();
		String query="update student set name=?, email=?, std=?, sec=?, over_all_percentage=?, gender=?, parent_contact=?, remarks=?, address=?, password=? where id=?";
		
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, student.getName());
			pst.setString(2, student.getEmail());
			pst.setString(3, student.getStd());
			pst.setString(4, student.getSec());
			pst.setString(5, student.getOverAllPercentage());
			pst.setString(6, student.getGender());
			pst.setString(7, student.getParentContact());
			pst.setString(8, student.getRemarks());
			pst.setString(9, student.getAddress());
			pst.setString(10, student.getPassword());
			
			pst.setInt(11, student.getId());
			pst.executeUpdate();
		
		con.close();
		return student;
		}
			catch (SQLException e) {
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public List<Student> getStudentByStd(String std) {
		Connection con =ConnectionUtil.getConnection();
		List<Student> list=new ArrayList<Student>();
		String sql="select * from Student where std =?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, std);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Student student = new Student();	
				student.setId(resultset.getInt(1));			
				student.setName(resultset.getString(2));
				student.setEmail(resultset.getString(3));
				student.setStd(resultset.getString(4));
				student.setSec(resultset.getString(5));
				student.setOverAllPercentage(resultset.getString(6));
				student.setGender(resultset.getString(7));
				student.setParentContact(resultset.getString(8));
				student.setRemarks(resultset.getString(9));
				student.setAddress(resultset.getString(10));
				student.setPassword(resultset.getString(11));

				list.add(student);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Student> getStudentByStdAndSec(String std, String sec) {
		Connection con =ConnectionUtil.getConnection();
		List<Student> list=new ArrayList<Student>();
		String sql="select * from Student where std =? and sec=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, std);
			pst.setString(2, sec);
			ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Student student = new Student();	
				student.setId(resultset.getInt(1));			
				student.setName(resultset.getString(2));
				student.setEmail(resultset.getString(3));
				student.setStd(resultset.getString(4));
				student.setSec(resultset.getString(5));
				student.setOverAllPercentage(resultset.getString(6));
				student.setGender(resultset.getString(7));
				student.setParentContact(resultset.getString(8));
				student.setRemarks(resultset.getString(9));
				student.setAddress(resultset.getString(10));
				student.setPassword(resultset.getString(11));

				list.add(student);
			}
			con.close();	
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String lower, String high) {
		Connection con =ConnectionUtil.getConnection();
		List<Student> list=new ArrayList<Student>();
		
		String sqlQuery="select * from Student where over_all_percentage>? and over_all_percentage<?";
	
			try {
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				
				pst.setString(1, lower);
				pst.setString(2, high);
			
				ResultSet resultset=pst.executeQuery();
				Student student = new Student();
				while(resultset.next()) {
					student=new Student();
					student.setId(resultset.getInt(1));
					student.setName(resultset.getString(2));
					student.setEmail(resultset.getString(3));
					student.setStd(resultset.getString(4));
					student.setSec(resultset.getString(5));
					student.setOverAllPercentage(resultset.getString(6));
					student.setGender(resultset.getString(7));
					student.setParentContact(resultset.getString(8));
					student.setRemarks(resultset.getString(9));
					student.setAddress(resultset.getString(10));
					student.setPassword(resultset.getString(11));
					list.add(student);
				}
				con.close();
				return list;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		Connection con =ConnectionUtil.getConnection();
		List<Student> list=new ArrayList<Student>();
		
		String sqlQuery="select * from Student";
	
			try {
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Student student = new Student();	
				student.setId(resultset.getInt(1));			
				student.setName(resultset.getString(2));
				student.setEmail(resultset.getString(3));
				student.setStd(resultset.getString(4));
				student.setSec(resultset.getString(5));
				student.setOverAllPercentage(resultset.getString(6));
				student.setGender(resultset.getString(7));
				student.setParentContact(resultset.getString(8));
				student.setRemarks(resultset.getString(9));
				student.setAddress(resultset.getString(10));
				student.setPassword(resultset.getString(11));

				list.add(student);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

}
