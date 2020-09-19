package com.dxc.dao;

import org.springframework.data.repository.CrudRepository;

import com.dxc.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	

}
