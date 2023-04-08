package com.abhi.school_data_management.service;

import java.util.ArrayList;
import java.util.List;
import com.abhi.school_data_management.dto.Student;
import com.abhi.school_data_management.repository.StudentRepository;
import com.abhi.school_data_management.repository.StudentRepositoryImp;
import com.abhi.school_data_management.util.AES;
import com.abhi.school_data_management.util.AppConstants;

public class StudentServiceImp implements StudentService{
	StudentRepository repository;
	{
		repository=new StudentRepositoryImp();
	}
	
	@Override
	public String saveStudent(Student student) {
		String encEmail=AES.encrypt(student.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(student.getAddress(),AppConstants.SECRETKEY);
		String encParentContact=AES.encrypt(student.getParentContact(),AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(student.getPassword(),AppConstants.SECRETKEY);
		student.setEmail(encEmail);
		student.setAddress(encAddress);
		student.setParentContact(encParentContact);
		student.setPassword(encPassword);
		
		return repository.saveStudent(student);
	}
	@Override
	public Student updateStudent(Student student) {	
		String encEmail=AES.encrypt(student.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(student.getAddress(),AppConstants.SECRETKEY);
		String encParentContact=AES.encrypt(student.getParentContact(),AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(student.getPassword(),AppConstants.SECRETKEY);
		
		student.setEmail(encEmail);
		student.setAddress(encAddress);
		student.setParentContact(encParentContact);
		student.setPassword(encPassword);
		return repository.updateStudent(student);//s;
	}
	
	
	@Override
	public Student studentLogin(String email, String password) {
		Student student = repository.studentLogin(email,password);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}

	
	@Override
	public Student getStudentById(int id) {
		Student student = repository.getStudentById(id);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
		System.out.println(decEmail);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		Student student = repository.getStudentById(id);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}



	@Override
	public List<Student> getStudentByStd(String std) {
		List<Student> list = repository.getStudentByStd(std);
		List<Student> slist=new  ArrayList<>();
		for(Student student:list) {
			String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			
			slist.add(student);
			
		}
		return slist;
	}

	@Override
	public List<Student> getStudentByStdAndSec(String std, String sec) {
		List<Student> list = repository.getStudentByStdAndSec(std,sec);
		List<Student> slist=new  ArrayList<>();
		for(Student student:list) {
			String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			
			slist.add(student);
			
		}
		return slist;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String lower, String high) {
		List<Student> list = repository.getStudentBetweenPercentage(lower, high);
		List<Student> slist=new  ArrayList<>();
		for(Student student:list) {
			String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			
			slist.add(student);
			
		}
		return slist;
	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> list = repository.getAllStudent();
		List<Student> slist=new  ArrayList<>();
		for(Student student:list) {
			String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(student.getAddress(),AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(student.getParentContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(student.getPassword(),AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			
			slist.add(student);
			
		}
		return slist;
	}

}
