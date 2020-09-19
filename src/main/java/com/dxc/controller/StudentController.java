	package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.dao.StudentRepository;
import com.dxc.model.Student;
@Controller
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value="student",method=RequestMethod.POST)
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
		 return studentRepository.save(student);
	}
	@RequestMapping(path="students/{id}",produces= {"application/xml"})
	@ResponseBody
	public Student getStudent(@PathVariable("id") int id) {
		Student student=studentRepository.findById(id).orElse(new Student());
		
		return student;
		
	}
	@RequestMapping("students")
	@ResponseBody
	public List<Student> getStudents() {
		List<Student> students =(List<Student>) studentRepository.findAll();
		return students;
	}
	

	@RequestMapping("student/{id}")
	public void delete(@PathVariable int id) {
		studentRepository.deleteById(id);
		
	}
	@RequestMapping("student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id) {
		Optional<Student> students=studentRepository.findById(id);
		if(!students.isPresent())
			return ResponseEntity.notFound().build();
		student.setId(id);
		studentRepository.save(student);
		return ResponseEntity.noContent().build();
		
	}
}
