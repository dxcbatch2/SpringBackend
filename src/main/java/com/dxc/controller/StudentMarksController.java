package com.dxc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dxc.dao.StudentMarksRepository;
import com.dxc.model.Marks;

public class StudentMarksController {
	StudentMarksRepository studentMarksRepository;
	@GetMapping("marks")
	public List<Marks> getMarks()
	{
		List<Marks> marks = (List<Marks>) studentMarksRepository.findAll();
		return marks;
	}
	
	@GetMapping(path="mark/{id}")
	public Marks getMark(@PathVariable("id") int id) 
	{
		Marks mark = studentMarksRepository.findById(id).orElse(new Marks());
		return mark;
	}
	
	@PostMapping("mark")
	public Marks save(@RequestBody Marks mark)
	{
		return studentMarksRepository.save(mark);
	}
	
	@PutMapping("mark")
	public Marks update(Marks mark)
	{
		return ((StudentMarksController) studentMarksRepository).update(mark);
	}


}
	