package com.arif.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arif.model.Student;
import com.arif.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) {
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}

	@RequestMapping(value = "/student.do", method = RequestMethod.POST)
	public String doSomeThing(@ModelAttribute Student student,
			BindingResult result, @RequestParam String actions,
			Map<String, Object> map) {

		Student studentResult = new Student();

		if ("add".equals(actions.toLowerCase())) {
			studentService.add(student);
			studentResult = student;
		} else if ("edit".equals(actions.toLowerCase())) {
			studentService.edit(student);
			studentResult = student;
		} else if ("delete".equals(actions.toLowerCase())) {
			studentService.delete(student.getStudentId());
			studentResult = new Student();
		} else if ("search".equals(actions.toLowerCase())) {
			Student searched = studentService
					.getStudent(student.getStudentId());
			studentResult = searched == null ? new Student() : searched;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";

	}
}
