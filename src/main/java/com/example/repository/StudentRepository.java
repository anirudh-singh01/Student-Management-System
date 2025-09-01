package com.example.repository;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student Repository Interface
 * This interface extends JpaRepository which provides basic CRUD operations
 * Spring automatically creates an implementation of this interface
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    /**
     * Find student by email
     * Spring automatically creates a method implementation based on the method name
     */
    Student findByEmail(String email);
    
    /**
     * Find students by first name
     */
    java.util.List<Student> findByFirstName(String firstName);
    
    /**
     * Find students by last name
     */
    java.util.List<Student> findByLastName(String lastName);
}
