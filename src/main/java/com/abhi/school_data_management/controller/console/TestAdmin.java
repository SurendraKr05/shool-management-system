package com.abhi.school_data_management.controller.console;

import com.abhi.school_data_management.dto.Admin;
import com.abhi.school_data_management.service.AdminService;
import com.abhi.school_data_management.service.AdminServiceImp;

public class TestAdmin {
	public static void main(String[] args) {
		AdminService service=new AdminServiceImp();
		Admin admin =new Admin();
		//admin.setAdminName("pavhitra");
		//admin.setEmail("pavhi@bcbvb.fg");
		//admin.setPassword("pvgghgf1213");
		
		//System.out.println(service.saveAdmin(admin));
	}

}
