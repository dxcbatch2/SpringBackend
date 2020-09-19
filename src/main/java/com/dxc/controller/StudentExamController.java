package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.dao.StudentExamRepository;
import com.dxc.model.Exam;




public class StudentExamController {
	@Autowired
	StudentExamRepository studentExamRepository;
	
	@RequestMapping(path="exams",produces= {"application/xml"})
	@ResponseBody
	public List<Exam> getExams(){
		List<Exam> exams =(List<Exam>) studentExamRepository.findAll();
		return exams;
	}
	@RequestMapping(path="exams/{id}",produces= {"application/xml"})
	@ResponseBody
	public Exam getExam(@PathVariable("eid") int eid) {
		Exam exam=studentExamRepository.findById(eid).orElse(new Exam());
		
		return exam;
		
	}
	@RequestMapping(value="exam",method=RequestMethod.POST)
	@ResponseBody
	public Exam addExam(@RequestBody Exam exam) {
		 return studentExamRepository.save(exam);
	}
}
