package com.abhi.school_data_management.repository;

import java.sql.Connection;
import java.util.List;

import com.abhi.school_data_management.dto.Teacher;

public interface TeacherRepository {
	//Connection getConnection();
	String saveTeacher(Teacher teacher);
	Teacher teacherLogin(String email,String password);
	
	Teacher getTeacherById(int id);
	Teacher deleteTeacher(int id);
	Teacher updateTeacher(Teacher teacher);
	
	List<Teacher> getTeacherBySubject(String subject);
	List<Teacher> getClassTeacher(String classTeacher);
	List<Teacher> getTeacherByContact(String contact);
	
	List<Teacher> getTeacherBySal(String sal);
	List<Teacher> getAllTeacher();
}
