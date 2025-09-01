package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Student Service Class
 * This class contains business logic and acts as a middle layer between
 * the controller/servlet and the repository
 */
@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    /**
     * CREATE - Save a new student
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    /**
     * READ - Get all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    /**
     * READ - Get student by ID
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    /**
     * READ - Get student by email
     */
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
    
    /**
     * UPDATE - Update an existing student
     */
    public Student updateStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found with id: " + student.getId());
    }
    
    /**
     * DELETE - Delete student by ID
     */
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
    
    /**
     * Check if student exists by email
     */
    public boolean existsByEmail(String email) {
        return studentRepository.findByEmail(email) != null;
    }
}
