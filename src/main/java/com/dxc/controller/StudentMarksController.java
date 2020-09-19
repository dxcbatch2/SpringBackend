package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.dao.StudentMarksRepository;
import com.dxc.model.Marks;
import com.dxc.model.Student;

public class StudentMarksController {
	StudentMarksRepository studentMarksRepository;
	@RequestMapping("marks")
	@ResponseBody
	public List<Marks> getMarks(){
		List<Marks> marks=(List<Marks>) studentMarksRepository.findAll();
		return marks;
	}
	@RequestMapping("marks/{id}")
	public ResponseEntity<Marks> getMarksById(@PathVariable("id") int id){
		Optional<Marks> marks=studentMarksRepository.findById(id);
		if(marks.isPresent()) {
			return new ResponseEntity<>(marks.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@RequestMapping(value="mark",method=RequestMethod.POST)
	@ResponseBody
	public Marks addMarks(@RequestBody Marks marks) {
		 return studentMarksRepository.save(marks);
	}	

}
