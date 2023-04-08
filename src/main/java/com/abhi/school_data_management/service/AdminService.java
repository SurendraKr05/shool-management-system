package com.abhi.school_data_management.service;

import java.util.List;

import com.abhi.school_data_management.dto.Admin;

public interface AdminService {
	String saveAdmin(Admin admin);
	Admin updateAdmin(Admin admin);
	Admin adminLogin(String email,String password);
	List<Admin> getAllAdmin();
	Admin getAdminById(int id);

}
