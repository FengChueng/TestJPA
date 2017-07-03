package com.zyl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.demo.jpa.SchoolDAO;
import com.zyl.demo.pojo.School;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolDAO schoolDAO;
	
	public List<School> queryAllSchool(){
		return schoolDAO.findAll();
	}
	
	public boolean addSchool(School school){
		schoolDAO.saveAndFlush(school);
		return true;
	}
}
