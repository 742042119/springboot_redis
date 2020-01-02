package com.entor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.entor.entity.Student;
import com.entor.mapper.StudentMapper;
import com.entor.service.IStudentService;

@Service
@CacheConfig(cacheNames="students")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentMapper studentdao;

	@Override
	@CacheEvict(allEntries=true)
	public void add(Student student) {
		studentdao.add(student);
	}

	@Override
	@CacheEvict(allEntries=true)
	public void update(Student student) {
		studentdao.update(student);
	}

	@Override
	@CacheEvict(allEntries=true)
	public void deleteById(int id) {
		studentdao.deleteById(id);
	}

	@Override
	@Cacheable(key="'student_'+#id")
//	@Cacheable(key="'student_'+#p0")@Chcheable作用：先从缓存里面查询是否有数据，如果有直接取出返回，否则查询数据库返回值保存在缓存，#p0指的是方法的第一个参数
	public Student queryById(int id) {
		return studentdao.queryById(id);
	}

	@Override
//	@CacheEvict 检查缓存是否拥有，否则到数据库里面查
	@Cacheable(key="'student_'+#p0+'_'+#p1")//student_是拼接的字符,拼接在占位符前面，如占位符是20则生成。student_20
	public List<Student> queryByPage(int currentPage, int pageSize) {
		return studentdao.queryByPage((currentPage-1)*pageSize, pageSize);
	}

	@Override
	public List<Student> queryAll() {
		return studentdao.queryAll();
	}

}
