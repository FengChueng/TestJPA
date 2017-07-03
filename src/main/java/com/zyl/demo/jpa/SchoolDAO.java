package com.zyl.demo.jpa;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyl.demo.pojo.School;

@Transactional(rollbackOn=Exception.class,value=TxType.NOT_SUPPORTED)
public interface SchoolDAO extends JpaRepository<School, Integer>{
	
}
