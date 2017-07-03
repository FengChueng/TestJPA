package com.zyl.demo.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="school")
@DynamicInsert
@DynamicUpdate
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name",nullable=true)
	private String name;
	@Column(name="level")
	@Enumerated(EnumType.STRING)
	private SchoolLevel schoolLevel;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="school")
	private Set<Department> departments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SchoolLevel getSchoolLevel() {
		return schoolLevel;
	}
	public void setSchoolLevel(SchoolLevel schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	public Set<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
}
