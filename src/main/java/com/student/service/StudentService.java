package com.student.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;
import com.student.exception.CustomException.StudentNotExist;
import com.student.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired StudentRepository repository;
	
	public StudentEntity createData(StudentEntity studentEntity) {
		return repository.save(studentEntity);
	}
	
	// get Data
	
		public StudentEntity getById(Long studentId)
		{
			StudentEntity byId=repository.findById(studentId)
					.orElseThrow(() -> new StudentNotExist("Student Not Found With "+ studentId))
					;
			return byId;
		}
		
		// Get All Student
		
		public List<StudentEntity>getAllStudent()
		{
			List<StudentEntity>all= repository.findAll();
			return all;
			
		}
		
		// UPdate Code
		
		public StudentEntity updatEntityStudentEntity(Long studentId, StudentEntity studentEntity)
		{
			StudentEntity byId= repository.findById(studentId).get();
			byId.setfName(studentEntity.getfName());
			byId.setlName(studentEntity.getlName());
			byId.setAddress(studentEntity.getAddress());
			byId.setAge(studentEntity.getAge());
			StudentEntity save= repository.save(byId);
			return save;
		}
		
		// Delete Student Data
		public String deleteStudentId(Long studentId){
			StudentEntity byId= repository.findById(studentId).get();
			repository.delete(byId);
			return "Data Sucessfully deleted ......!";
			
		}
	

}
