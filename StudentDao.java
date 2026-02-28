package DAO;

import java.util.List;
import Student.Student;

public interface StudentDao {
    
    // 1. Add new student
    void addStudent(Student student);
    
    // 2. View all students
    List<Student> getAllStudents();
    
    // 3. Search student by ID
    Student getStudentById(int id);
    
    // 4. Update student marks (Grade calculation happens in the code)
    void updateStudentMarks(int id, double marks);
    
    // 5. Delete student
    void deleteStudent(int id);
}
