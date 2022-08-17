package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	StudentServices studentService;
	
	@RequestMapping(value="/hello", method= RequestMethod.GET)
	public String greeting() {
		//return "Hello this is first spring boot program";
		return " HI this is spring boot ";
	}
	
	@RequestMapping(value="/hello", method= RequestMethod.POST)
	public String greeting1() {
		//return "Hello this is first spring boot program";
		return "HI this is spring boot :) this if from POST";
	}
	
	@RequestMapping(value="/student", method= RequestMethod.POST)
	public Student save(Student student) {
	System.out.println("check ");
		return studentService.save(student);
	
	}
	
	@RequestMapping(value="/student" ,method=RequestMethod.GET)
	public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
	
		Student student = studentService.fetchStudentById(id);
		
		if (student==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(student);
		}
	}
}
