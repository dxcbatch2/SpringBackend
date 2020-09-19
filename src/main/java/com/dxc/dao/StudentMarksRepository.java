package com.dxc.dao;

import org.springframework.data.repository.CrudRepository;

import com.dxc.model.Marks;

public interface StudentMarksRepository extends CrudRepository<Marks, Integer> {

}
