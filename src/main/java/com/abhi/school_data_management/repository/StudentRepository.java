package com.abhi.school_data_management.repository;

import java.sql.Connection;
import java.util.List;

import com.abhi.school_data_management.dto.Student;

public interface StudentRepository {
	//Connection getConnection();
	Student studentLogin(String email,String password);
	String saveStudent(Student student);
	Student getStudentById(int id);
	Student deleteStudent(int id);
	Student updateStudent(Student student);
	List<Student> getStudentByStd(String std);
	List<Student> getStudentByStdAndSec(String std,String sec);
	List<Student> getStudentBetweenPercentage(String lower,String high);
	List<Student> getAllStudent();
}
