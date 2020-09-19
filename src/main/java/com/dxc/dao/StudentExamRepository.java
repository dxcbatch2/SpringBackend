package com.dxc.dao;

import org.springframework.data.repository.CrudRepository;

import com.dxc.model.Exam;

public interface StudentExamRepository extends CrudRepository<Exam, Integer> {

}
