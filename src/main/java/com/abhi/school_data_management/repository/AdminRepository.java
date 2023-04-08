package com.abhi.school_data_management.repository;

import java.util.List;

import com.abhi.school_data_management.dto.Admin;

public interface AdminRepository {
	//Connection getConnection();
	String saveAdmin(Admin admin);
	Admin getAdminById(int id);
	Admin updateAdmin(Admin admin);
	Admin adminLogin(String email,String password);
	List<Admin> getAllAdmin();
}
