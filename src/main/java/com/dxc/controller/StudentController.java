	package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
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
	
	
	@DeleteMapping("student/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public void delete(@PathVariable("id") int id) {
		studentRepository.deleteById(id);
		
	}
	@RequestMapping("student")
	@CrossOrigin(origins="http:localhost:4200")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id")int id,@RequestBody Student studentd)
	{
		Student student = studentRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));

        student.setName(studentd.getName());
        student.setEmail(studentd.getEmail());
        student.setMobile(studentd.getMobile());

        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
	}
}
