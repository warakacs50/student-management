# Student Management System (Java CLI + MySQL)

A console-based Java application to manage student records with CRUD operations, connected to a MySQL database using JDBC.  
The project follows a layered architecture (UI, Service, DAO, Model) and demonstrates backend development fundamentals such as input validation, database integration, and clean separation of concerns.  
Built as a foundation project for learning Java backend development.

---

## Features

- Add new students
- View all students
- Update student details by ID (name, email, age)
- Delete students by ID
- Input validation (valid email, age > 0)
- Auto-incremented student ID handled by database
- Menu-driven CLI interface

---

## Technologies Used

- Java 17
- MySQL
- JDBC
- Console (CLI)

---

## Database Schema


**Table: `students`**

```sql
CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    age INT NOT NULL
);
```
---
## Project Structure
```css
##Project Structure 

com.kavinda.sms
├── model
│   └── Student.java
├── service
│   └── StudentService.java
├── dao
│   └── StudentDAO.java
├── util
│   └── DBConnection.java
└── ui
    ├── StudentCLI.java
    └── Main.java
```

---

## How to Run

01.Clone the repository:
```bash
git clone https://github.com/your-username/student-management-system.git
```
02.Create the database using the SQL above.

03.Update database credentials in DBConnection.java.

04.Compile and run:

```bash
javac -d out src/com/kavinda/sms/**/*.java
java -cp out com.kavinda.sms.Main
```
---

---

## Next Steps
```markdown

Convert CLI to Spring Boot REST API

-Add search by email or filters

-Add logging and exception handling

-Add unit tests

-Add pagination for viewing students

-Add input constraints for email format, max length, and age limit
```

---

### Author

Kavinda UJ Warakamura

