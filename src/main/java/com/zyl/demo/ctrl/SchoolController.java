package com.zyl.demo.ctrl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.demo.pojo.Department;
import com.zyl.demo.pojo.School;
import com.zyl.demo.pojo.SchoolLevel;
import com.zyl.demo.service.SchoolService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@ApiOperation(notes="获取学校列表",httpMethod="GET", value = "getAllSchool")
	@RequestMapping(value="/getAllSchool",method=RequestMethod.GET)
	public List<School> getAllSchool() {
		return schoolService.queryAllSchool();
	}

	@ApiOperation(value="addSchool",notes="添加学校",httpMethod="POST")
	@ApiImplicitParams({
				@ApiImplicitParam(name="name",dataType="String",paramType="form"),
				@ApiImplicitParam(name="level",dataType="String",paramType="form",defaultValue="A",allowableValues="range[A,B,C]")
			})
	@RequestMapping(value="/addSchool",params={"name","level"},method=RequestMethod.POST)
	public boolean addSchool(@RequestParam(value="name")String name,@RequestParam(value="level") String level){
		School school = new School();
		SchoolLevel schoolLevel = SchoolLevel.valueOf(level);
		Department dept = new Department();
		dept.setName("后勤");
		dept.setSchool(school);
		school.setName(name);
		
		Set<Department> departments = new HashSet<Department>();
		departments.add(dept);
		school.setDepartments(departments);
		school.setSchoolLevel(schoolLevel);
		
		return schoolService.addSchool(school); 
	}
}
