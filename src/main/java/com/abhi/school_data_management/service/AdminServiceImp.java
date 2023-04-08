package com.abhi.school_data_management.service;

import java.util.ArrayList;
import java.util.List;

import com.abhi.school_data_management.dto.Admin;
import com.abhi.school_data_management.repository.AdminRepository;
import com.abhi.school_data_management.repository.AdminRepositoryImp;
import com.abhi.school_data_management.util.AES;
import com.abhi.school_data_management.util.AppConstants;

public class AdminServiceImp implements AdminService{
	AdminRepository repository;
	{
		repository=new AdminRepositoryImp();
	}
	@Override
	public String saveAdmin(Admin admin) {
		String encAdminName=AES.encrypt(admin.getAdminName(), AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(admin.getPassword(),AppConstants.SECRETKEY);
		String encEmail=AES.encrypt(admin.getEmail(), AppConstants.SECRETKEY);
		admin.setAdminName(encAdminName);
		admin.setPassword(encPassword);
		admin.setEmail(encEmail);
		return repository.saveAdmin(admin);
	}
	@Override
	public Admin updateAdmin(Admin admin) {
		String encAdminName=AES.encrypt(admin.getAdminName(), AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(admin.getPassword(),AppConstants.SECRETKEY);
		String encEmail=AES.encrypt(admin.getEmail(), AppConstants.SECRETKEY);
		admin.setAdminName(encAdminName);
		admin.setPassword(encPassword);
		admin.setEmail(encEmail);
		
		 return  repository.updateAdmin(admin);
	}
	
	@Override
	public Admin adminLogin(String email, String password) {
		Admin admin = repository.adminLogin(email, password);
		String decEmail=AES.decrypt(admin.getEmail(), AppConstants.SECRETKEY);
		String decAdminName=AES.decrypt(admin.getAdminName(),AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(admin.getPassword(),AppConstants.SECRETKEY);
		admin.setEmail(decEmail);
		admin.setAdminName(decAdminName);
		admin.setPassword(decPassword);
		return admin;
	}
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list = repository.getAllAdmin();
		List<Admin> alist=new  ArrayList<>();
		for(Admin admin:list) {
			String decEmail=AES.decrypt(admin.getEmail(), AppConstants.SECRETKEY);
			String decAdminName=AES.decrypt(admin.getAdminName(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(admin.getPassword(),AppConstants.SECRETKEY);
			admin.setAdminName(decAdminName);
			admin.setEmail(decEmail);
			admin.setPassword(decPassword);
			
			alist.add(admin);
			
		}
		return alist;
	}
	@Override
	public Admin getAdminById(int id) {
		Admin admin=repository.getAdminById(id);
		String encEmail=AES.decrypt(admin.getEmail(), AppConstants.SECRETKEY);
		String decAdminName=AES.decrypt(admin.getAdminName(),AppConstants.SECRETKEY);
		String encPassword=AES.decrypt(admin.getPassword(),AppConstants.SECRETKEY);
		admin.setEmail(encEmail);
		admin.setAdminName(decAdminName);
		admin.setPassword(encPassword);
		return admin;
	}
	
}
