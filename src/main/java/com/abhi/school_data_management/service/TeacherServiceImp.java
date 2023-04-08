package com.abhi.school_data_management.service;

import java.util.ArrayList;
import java.util.List;

import com.abhi.school_data_management.dto.Teacher;
import com.abhi.school_data_management.repository.TeacherRepository;
import com.abhi.school_data_management.repository.TeacherRepositoryImp;
import com.abhi.school_data_management.util.AES;
import com.abhi.school_data_management.util.AppConstants;

public class TeacherServiceImp implements TeacherService{
	TeacherRepository repository;
	{
		repository=new TeacherRepositoryImp();
	}
	@Override
	public String saveTeacher(Teacher teacher) {
		String encEmail=AES.encrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(teacher.getAddress(),AppConstants.SECRETKEY);
		String encContact=AES.encrypt(teacher.getContact(),AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(teacher.getPassword(),AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);;
		teacher.setPassword(encPassword);
		
		return repository.saveTeacher(teacher);
	}

	@Override
	public Teacher teacherLogin(String email, String password) {
		Teacher teacher=repository.teacherLogin(email,password);
		String encEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
		String encContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
		String encPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);;
		teacher.setPassword(encPassword);
		return teacher;
	}

	@Override
	public Teacher getTeacherById(int id) {
		Teacher teacher=repository.getTeacherById(id);
		String encEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
		String encContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
		String encPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);;
		teacher.setPassword(encPassword);
		return teacher;
	}

	@Override
	public Teacher deleteTeacher(int id) {
		Teacher teacher=repository.getTeacherById(id);
		String encEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
		String encContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
		String encPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);;
		teacher.setPassword(encPassword);
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
	
		String encEmail=AES.encrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(teacher.getAddress(),AppConstants.SECRETKEY);
		String encContact=AES.encrypt(teacher.getContact(),AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(teacher.getPassword(),AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);;
		teacher.setPassword(encPassword);
		repository.updateTeacher(teacher);
		return teacher;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
		List<Teacher> list = repository.getTeacherBySubject(subject);
		List<Teacher> tlist=new  ArrayList<>();
		for(Teacher teacher:list) {
			String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
			String decContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);;
			teacher.setPassword(decPassword);
			tlist.add(teacher);
		}
		return tlist;
	}

	@Override
	public List<Teacher> getClassTeacher(String classTeacher) {
		List<Teacher> list = repository.getClassTeacher(classTeacher);
		List<Teacher> tlist=new  ArrayList<>();
		for(Teacher teacher:list) {
			String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
			String decContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);;
			teacher.setPassword(decPassword);
			tlist.add(teacher);
		}
		return tlist;
	}

	@Override
	public List<Teacher> getTeacherByContact(String contact) {
		List<Teacher> list = repository.getTeacherByContact(contact);
		List<Teacher> tlist=new  ArrayList<>();
		for(Teacher teacher:list) {
			String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
			String decContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);;
			teacher.setPassword(decPassword);
			tlist.add(teacher);
		}
		return tlist;
	}

	@Override
	public List<Teacher> getTeacherBySal(String sal) {
		List<Teacher> list = repository.getTeacherBySal(sal);
		List<Teacher> tlist=new  ArrayList<>();
		for(Teacher teacher:list) {
			String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
			String decContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);;
			teacher.setPassword(decPassword);
			tlist.add(teacher);
		}
		return tlist;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> list = repository.getAllTeacher();
		List<Teacher> tlist=new  ArrayList<>();
		for(Teacher teacher:list) {
			String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(teacher.getAddress(),AppConstants.SECRETKEY);
			String decContact=AES.decrypt(teacher.getContact(),AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(teacher.getPassword(),AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);;
			teacher.setPassword(decPassword);
			tlist.add(teacher);
		}
		return tlist;
	}

}
