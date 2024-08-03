
package com.student.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentEntity;
import com.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	// post data.
	@PostMapping("/post")
	 public StudentEntity creatStudentEntity(@RequestBody StudentEntity studentEntity) {
		 return studentService.createData(studentEntity);
	 }
	
	// Get Student By Id
	@GetMapping("/{studentId}")
	public StudentEntity getByStudentEntity(@PathVariable Long studentId) {
		StudentEntity byId= studentService.getById(studentId);
		return byId;
	}

	
	// Get All Student data
	@GetMapping("/gettLst")
	public List<StudentEntity> getAllData(){
	List<StudentEntity>allStudent= studentService.getAllStudent();
	return allStudent;
	}
	 
	
	// Update Student 
	@PutMapping("/update/{studentId}")
	public StudentEntity updateStudentEntity(@PathVariable Long studentId, @Valid @RequestBody StudentEntity studentEntity) {
	StudentEntity updateStudent= studentService.updatEntityStudentEntity(studentId, studentEntity); 
	return updateStudent;
	}
	
	// Delete Student Data
	@DeleteMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable Long studentId) {
		String deleteStudent= studentService.deleteStudentId(studentId);
		return deleteStudent;
	}
	

}
