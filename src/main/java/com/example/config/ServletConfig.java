package com.example.config;

import com.example.servlet.StudentServlet;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Servlet Configuration Class
 * This class explicitly registers servlets with Spring Boot
 */
@Configuration
public class ServletConfig {
    
    @Autowired
    private StudentService studentService;
    
    /**
     * Register the StudentServlet with the path /students/*
     */
    @Bean
    public ServletRegistrationBean<StudentServlet> studentServletRegistration() {
        ServletRegistrationBean<StudentServlet> registration = new ServletRegistrationBean<>();
        StudentServlet servlet = new StudentServlet();
        servlet.setStudentService(studentService);
        registration.setServlet(servlet);
        registration.addUrlMappings("/students/*");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
