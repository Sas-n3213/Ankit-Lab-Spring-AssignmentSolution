package com.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listAllRegisteredStudents(Model theModel) {
		List<Student> students = studentService.findAllStudents();
		theModel.addAttribute("Students", students);
		return "student_list";
	}

	@RequestMapping("/add")
	public String showFormForAddingStudent(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "student_form";
	}

	@PostMapping("/save")
	public String saveTheStudent(@RequestParam("studentId") long studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println("Saving student...");
		Student student = new Student();
		if (studentId != 0) {

			student = studentService.findStudentById(studentId).get();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(firstName, lastName, course, country);
		}

		studentService.saveStudent(student);

		return "redirect:/student/list";
	}
	
	@RequestMapping("/edit")
	public String editStudentDetails(@RequestParam("studentId") long studentId, Model theModel) {
		Student student = studentService.findStudentById(studentId).get();
		theModel.addAttribute("Student", student);
		return "student_form";
	}
	
	@RequestMapping("/delete")
	public String removeStudent(@RequestParam("studentId") long studentId) {
		studentService.deleteStudentById(studentId);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}