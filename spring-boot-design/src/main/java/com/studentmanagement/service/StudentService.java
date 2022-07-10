package com.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dao.StudentRepository;
import com.studentmanagement.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> findStudentById(long id) {
		return studentRepository.findById(id);
	}

	public void saveStudent(Student theStudent) {
		studentRepository.save(theStudent);
	}

	public void deleteStudentById(long id) {

		if (findStudentById(id).isPresent()) {
			studentRepository.deleteById(id);
		}

	}
}