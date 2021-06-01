package com.restapi.jpa.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restapi.jpa.entities.StudentRowMapper;

//import org.springframework.data.repository.CrudRepository;

import com.restapi.jpa.entities.Students;

@Repository
public class StudentRepository 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//create table
	public int createTable()
	{
		String createTableQuery = "CREATE TABLE IF NOT EXISTS students_details(stud_id INT NOT NULL AUTO_INCREMENT,student_name VARCHAR(255),student_mail_id VARCHAR(255),student_stream VARCHAR(255),PRIMARY KEY(stud_id))";
		int rows = jdbcTemplate.update(createTableQuery);
		System.out.println(rows);
		return rows;
	}
	
	//get all students
	public List<Students> findAll()
	{
		return (List<Students>)jdbcTemplate.query("select *from students_details", new StudentRowMapper());
	}
	
	//get student by id
	public Students findById(int studId)
	{
		String query = "select * from students_details where stud_id = ?";
		Students student = null;
		try
		{
			student = jdbcTemplate.queryForObject(query, new StudentRowMapper(), new Object[] {studId});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}
	
	//add new students
	public void insertStudent(Students stud)
	{
		String insertQuery = "insert into students_details(student_name,student_mail_id,student_stream) values(?,?,?)";
		jdbcTemplate.update(insertQuery, new Object[] {stud.getStudentName(),stud.getStudentMailId(),stud.getStudentStream()});
		
		//return findById(stud.getStudentId());
		
	}
	
	public void deleteById(int studId)
	{
		jdbcTemplate.update("delete from students_details where stud_id = ?",studId);
	}
	
	public void updateStudent(Students stud,int studId)
	{
		String updateQuery = "update students_details set student_name = ?,student_mail_id = ?,student_stream = ? where stud_id = ?";
		Object[] params = {stud.getStudentName(),stud.getStudentMailId(),stud.getStudentStream(),studId};
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		
		jdbcTemplate.update(updateQuery,params,types);
	}
     
}
