package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;



@Component
public class DoctorDAO {
	 @Autowired
	    JdbcTemplate jt;

	    public ArrayList<Doctor> getAllDoctors() {

	        String SQL_query = "SELECT * FROM doctors";

	        RowMapper<Doctor> rowMapper = new RowMapper<Doctor>() {
	            public Doctor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	                Doctor doctor = new Doctor();
	                doctor.setDoctorid(resultSet.getInt("doctorid"));
	                doctor.setFullname(resultSet.getString("fullname"));
	                doctor.setSpecializationid(resultSet.getInt("specializationid"));
	                doctor.setQualification(resultSet.getString("qualification"));
	                doctor.setExperience(resultSet.getInt("experience"));
	                doctor.setDesignation(resultSet.getString("designation"));
	                doctor.setPhoto(resultSet.getString("photo"));
	                return doctor;
	            }
	        };

	        ArrayList<Doctor> doctors = (ArrayList<Doctor>) jt.query(SQL_query, rowMapper);

	        return doctors;
	    }
}
