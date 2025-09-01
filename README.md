# Student Management System

A simple CRUD (Create, Read, Update, Delete) application for managing students built with Spring Boot, Servlets, and HTML.

## Features

- **Create**: Add new students with first name, last name, email, and age
- **Read**: View all students and individual student details
- **Update**: Edit existing student information
- **Delete**: Remove students from the system
- **Simple UI**: Clean, responsive HTML interface
- **In-memory Database**: H2 database for easy testing

## Technology Stack

- **Backend**: Spring Boot 2.7.0
- **Web Layer**: Servlets
- **Database**: H2 (in-memory)
- **Frontend**: HTML, CSS, JavaScript
- **Build Tool**: Maven

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── StudentManagementApplication.java    # Main Spring Boot class
│   │       ├── config/
│   │       │   └── ServletConfig.java              # Servlet configuration
│   │       ├── model/
│   │       │   └── Student.java                    # Student entity
│   │       ├── repository/
│   │       │   └── StudentRepository.java          # Data access layer
│   │       ├── service/
│   │       │   └── StudentService.java             # Business logic layer
│   │       └── servlet/
│   │           └── StudentServlet.java             # HTTP request handler
│   └── resources/
│       ├── static/
│       │   └── index.html                          # Main UI page
│       └── application.properties                  # Configuration
└── pom.xml                                         # Maven dependencies
```

## Quick Start

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone or download the project**

2. **Navigate to project directory**
   ```bash
   cd student-management
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Open your browser**
   - Main application: http://localhost:8080
   - H2 Database Console: http://localhost:8080/h2-console

### Using the Application

1. **Add a Student**: Fill out the form and click "Add Student"
2. **View Students**: All students are displayed in the table below
3. **Edit Student**: Click the "Edit" button next to any student
4. **Delete Student**: Click the "Delete" button (with confirmation)
5. **Refresh**: Use the "Refresh List" button to reload data

## API Endpoints

- `GET /students/` - Get all students
- `GET /students/{id}` - Get student by ID
- `POST /students/` - Create new student
- `PUT /students/{id}` - Update existing student
- `DELETE /students/{id}` - Delete student

## Database

The application uses H2 in-memory database which:
- Automatically creates tables on startup
- Resets data when the application restarts
- Provides a web console for debugging at `/h2-console`

### H2 Database Console

**Access**: http://localhost:8080/h2-console

**Connection Settings**:
- **Driver Class**: `org.h2.Driver`
- **JDBC URL**: `jdbc:h2:mem:studentdb`
- **User Name**: `sa`
- **Password**: `(leave empty)`

**Quick SQL Commands**:
```sql
-- View all students
SELECT * FROM STUDENTS;

-- Count students
SELECT COUNT(*) FROM STUDENTS;

-- Find students by age
SELECT * FROM STUDENTS WHERE AGE > 20;
```

**Note**: Data is in-memory and resets on application restart. Perfect for development and testing.

## Development

- The application automatically reloads when you make changes (thanks to Spring Boot DevTools)
- All CRUD operations are logged to the console
- SQL queries are displayed for debugging purposes

## Troubleshooting

- **Port already in use**: Change `server.port` in `application.properties`
- **Database issues**: Check H2 console at http://localhost:8080/h2-console
- **Build errors**: Ensure Java 8+ and Maven 3.6+ are installed

## Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database](http://www.h2database.com/)
- [Java Servlets](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
