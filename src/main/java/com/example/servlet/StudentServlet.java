package com.example.servlet;

import com.example.model.Student;
import com.example.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Student Servlet Class
 * This servlet handles all HTTP requests for student CRUD operations
 * It acts as the controller layer in our application
 */
public class StudentServlet extends HttpServlet {
    
    private StudentService studentService;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Service is now set manually through setter method
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            if (pathInfo == null || pathInfo.equals("/")) {
                // GET /students - Get all students
                getAllStudents(response);
            } else {
                String[] pathParts = pathInfo.split("/");
                if (pathParts.length == 2) {
                    Long id = Long.parseLong(pathParts[1]);
                    getStudentById(id, response);
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path");
                }
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            // POST /students - Create new student
            Student student = objectMapper.readValue(request.getReader(), Student.class);
            Student savedStudent = studentService.saveStudent(student);
            
            response.setStatus(HttpServletResponse.SC_CREATED);
            objectMapper.writeValue(response.getWriter(), savedStudent);
            
        } catch (javax.persistence.PersistenceException e) {
            // Handle unique constraint violations
            if (e.getCause() != null && e.getCause().getMessage().contains("Unique index")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                objectMapper.writeValue(response.getWriter(), 
                    java.util.Map.of("error", "Email already exists. Please use a different email address."));
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } catch (RuntimeException e) {
            // Handle business logic exceptions
            if (e.getMessage().contains("Email already exists")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                objectMapper.writeValue(response.getWriter(), 
                    java.util.Map.of("error", e.getMessage()));
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            if (pathInfo != null && pathInfo.split("/").length == 2) {
                Long id = Long.parseLong(pathInfo.split("/")[1]);
                
                // PUT /students/{id} - Update student
                Student student = objectMapper.readValue(request.getReader(), Student.class);
                student.setId(id);
                Student updatedStudent = studentService.updateStudent(student);
                
                objectMapper.writeValue(response.getWriter(), updatedStudent);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (javax.persistence.PersistenceException e) {
            // Handle unique constraint violations
            if (e.getCause() != null && e.getCause().getMessage().contains("Unique index")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                objectMapper.writeValue(response.getWriter(), 
                    java.util.Map.of("error", "Email already exists. Please use a different email address."));
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } catch (RuntimeException e) {
            // Handle business logic exceptions
            if (e.getMessage().contains("Email already exists")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                objectMapper.writeValue(response.getWriter(), 
                    java.util.Map.of("error", e.getMessage()));
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            if (pathInfo != null && pathInfo.split("/").length == 2) {
                Long id = Long.parseLong(pathInfo.split("/")[1]);
                
                // DELETE /students/{id} - Delete student
                studentService.deleteStudent(id);
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    private void getAllStudents(HttpServletResponse response) throws IOException {
        List<Student> students = studentService.getAllStudents();
        objectMapper.writeValue(response.getWriter(), students);
    }
    
    private void getStudentById(Long id, HttpServletResponse response) throws IOException {
        java.util.Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            objectMapper.writeValue(response.getWriter(), student.get());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found");
        }
    }
}
