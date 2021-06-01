package com.restapi.jpa.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.jpa.dao.StudentRepository;
import com.restapi.jpa.entities.Students;

@Component
public class StudentServices 
{
	@Autowired
	private StudentRepository studentRepository;
     //get all students
	public List<Students> getAllStudents()
	{
		List<Students> studentsList = (List<Students>)this.studentRepository.findAll();
		return studentsList;
	}
	
	//get single student by id
	public Students getStudentById(int studentId)
	{
		Students stud = null;
		try {
			stud = this.studentRepository.findById(studentId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stud;	
	}
	
	//adding new students
	public void addStudent(Students stud)
	{
		studentRepository.insertStudent(stud);
		//return result;
	}
	
	//delete student 
	public void deleteStudent(int studId)
	{
		this.studentRepository.deleteById(studId);
	}
	
	//update student by id
	public void updateStudent(Students stud,int studId)
	{
		stud.setStudentId(studId);
		this.studentRepository.updateStudent(stud,studId);
	}
}
