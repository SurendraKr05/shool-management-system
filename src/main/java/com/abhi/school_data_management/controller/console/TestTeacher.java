package com.abhi.school_data_management.controller.console;

import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.service.TeacherService;
import com.abhi.school_data_management.service.TeacherServiceImp;

public class TestTeacher {
public static void main(String[] args) {
	TeacherService service=new TeacherServiceImp();
	Teacher teacher=new Teacher();
	
	teacher.setName("raas");
	teacher.setEmail("rsgsgs@gmail.com");
	teacher.setClassTeacher("XI");
	teacher.setContact("8999218522");
	teacher.setSal("752500");
	teacher.setSubject("SQL1");
	teacher.setAddress("Bihar1");
	teacher.setPassword("rass13293");
	
	System.out.println(service.saveTeacher(teacher));
	//System.out.println(service.getTeacherById(1));

	//System.out.println(service.getAllTeacher());
}
}
