package com.entor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Student;
import com.entor.service.impl.StudentServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl dao;

	@RequestMapping("/add")
	public void add(Student student) {
		dao.add(student);
	}
	
	@RequestMapping("/update")
	public void update(Student s) {
		dao.update(s);
	}
	
	@RequestMapping("/deleteById")
	public String delete(int id) {
		dao.deleteById(id);
		return "删除成功";
	}
	
	@RequestMapping("/queryById")
	public Student queryById(int id) {
		return dao.queryById(id);
	}
	
	@RequestMapping("/queryByPage")
	public List<Student> queryByPage(int currentPage,int pageSize) {
		return dao.queryByPage(currentPage, pageSize);
	}
	
	@RequestMapping("/queryByPage2")
	public PageInfo<Student> queryByPage2(int currentPage,int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<Student> list = dao.queryAll();
		PageInfo<Student> pf = new PageInfo<Student>(list);
		return pf;
	}
	
	
	
}
