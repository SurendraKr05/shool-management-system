package com.abhi.school_data_management.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abhi.school_data_management.dto.Admin;
import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.util.ConnectionUtil;

public class AdminRepositoryImp implements AdminRepository{

	@Override
	public String saveAdmin(Admin admin) {
		Connection con=ConnectionUtil.getConnection();
		String sql="insert into admin(name,email,pass)values(?,?,?)";	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, admin.getAdminName());
			pst.setString(2, admin.getEmail());
			pst.setString(3, admin.getPassword());

		int res=pst.executeUpdate();
		con.close();
		return res+" row added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Admin updateAdmin(Admin admin) {
		Connection con =ConnectionUtil.getConnection();
		String sqlQuery="update admin set name=?,email=?,pass=? where id=?";	
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sqlQuery);
				pst.setString(1, admin.getAdminName());
				pst.setString(2, admin.getEmail());
				pst.setString(3, admin.getPassword());
				pst.setInt(4, admin.getId());
				pst.executeUpdate();			
			con.close();
			return admin;
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public Admin adminLogin(String email, String password) {
		Connection con=ConnectionUtil.getConnection();
		Admin admin=null;
		String sql="SELECT * FROM admin WHERE email=? AND password=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet resultset=pst.executeQuery();
			if(resultset.next())
			{
				admin=new Admin();
				admin.setId(resultset.getInt(1));
				admin.setAdminName(resultset.getString(2));
				admin.setPassword(resultset.getString(3));		
			}
			con.close();
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		Connection con =ConnectionUtil.getConnection();
		List<Admin> list=new ArrayList<Admin>();
		
		String sqlQuery="select * from admin";
	
			try {
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				ResultSet resultset=pst.executeQuery();
			while(resultset.next()) {
				Admin admin = new Admin();	
				admin.setId(resultset.getInt(1));			
				admin.setAdminName(resultset.getString(2));
				admin.setEmail(resultset.getString(3));
				admin.setPassword(resultset.getString(4));
				list.add(admin);
			}
				con.close();
			return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public Admin getAdminById(int id) {
		Admin admin=null;
		Connection con =ConnectionUtil.getConnection();
		String sql="select * from admin where id =?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet resultset=pst.executeQuery();
		while(resultset.next()) {
			admin = new Admin();	
			admin.setId(resultset.getInt(1));
			admin.setAdminName(resultset.getString(2));
			admin.setEmail(resultset.getString(3));
			admin.setPassword(resultset.getString(4));
		}
			con.close();
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
