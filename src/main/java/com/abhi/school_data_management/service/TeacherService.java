package com.abhi.school_data_management.service;

import java.util.List;
import com.abhi.school_data_management.dto.Teacher;

public interface TeacherService {
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
