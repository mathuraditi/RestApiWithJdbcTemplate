package com.restapi.jpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.jpa.Services.StudentServices;
import com.restapi.jpa.entities.Students;

@RestController
public class StudentControoler 
{
	@Autowired
	private StudentServices studentServices;
	
   //get all students handler
	@GetMapping("/students")
	public List<Students> getStudents()
	{
		List<Students> studentList = this.studentServices.getAllStudents();
		return studentList;
	}
	
	//get single student handler
	@GetMapping("/students/{id}")
	public Students getStudents(@PathVariable("id") int id)
	{
		return this.studentServices.getStudentById(id);
	}
	
	//add new student handler
	@PostMapping("/students")
	public void addStudents(@RequestBody Students stud)
	{
		studentServices.addStudent(stud);
	}
	
	//delete student handler
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId)
	{
		this.studentServices.deleteStudent(studentId);
	}
	
	@PutMapping("/students/{studentId}")
	public void updateStudent(@RequestBody Students stud,@PathVariable("studentId") int studentId)
	{
		this.studentServices.updateStudent(stud, studentId);
	}
}
