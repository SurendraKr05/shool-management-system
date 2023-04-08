package com.abhi.school_data_management.controller.console;

import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.service.StudentService;
import com.abhi.school_data_management.service.StudentServiceImp;

public class TestSaveStudent {
	public static void main(String[] args) {
		StudentService service=new StudentServiceImp();
		Student student =new Student();
		student.setName("Abhijeet");
		student.setEmail("abhi5@gmail.com");
		student.setGender("male");
		student.setOverAllPercentage("99.99");
		student.setParentContact("877846611");
		student.setSec("X");
		student.setStd("XXI");
		student.setRemarks("Java Full Stack");
		student.setAddress("mp");
		student.setPassword("sik1213");
		//System.out.println(service.updateStudent(student));
		
		
	System.out.println(service.saveStudent(student));
		//System.out.println(service.getStudentById(1));
		//System.out.println(service.getAllStudent());
		//System.out.println(service.getStudentByStd("XI"));
		//System.out.println(service.deleteStudent(3));
		//System.out.println(service.getStudentByStdAndSec("XII","B"));
	}

}
