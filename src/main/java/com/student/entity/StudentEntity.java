package com.student.entity;


import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity

public class StudentEntity {
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private Long studentId;
	@NotEmpty(message = "First name should not be Empty")
	
	@NotEmpty
	private String fName;
	
	@NotEmpty
	private String lName;
	@Size(min = 2,max = 30,message= "Please Enter valid address..")
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private Long age;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "invailid mobile number")
	private String mobileNumber;

}
