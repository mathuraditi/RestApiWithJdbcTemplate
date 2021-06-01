package com.restapi.jpa.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Students>{
	
	public Students mapRow(ResultSet result,int rowNum) throws SQLException {
		
		Students student = new Students();
		student.setStudentId(result.getInt("stud_id"));
		student.setStudentName(result.getString("student_name"));
		student.setStudentMailId(result.getString("student_mail_id"));
		student.setStudentStream(result.getString("student_stream"));
		
		return student;
	}

}
