package DAO;
 	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Student.Student;

public class studentimp implements StudentDao {
	private Connection getConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String user = "root";
	    String pass = "Kavy@2025";
	    return DriverManager.getConnection(url, user, pass);
	}
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(name,age,course,marks,grade) values (?,?,?,?,?)";
		try(Connection con = getConnection();PreparedStatement pst = con.prepareStatement(query);){
			pst.setString(1,student.getName());
			pst.setInt(2,student.getAge());
			pst.setString(3, student.getCourse());
			pst.setDouble(4, student.getMarks());
			pst.setString(5, student.getGrade());
			int cnt = pst.executeUpdate();
			System.out.println("Data saved successfully!, rows affected "+cnt);
		}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
		
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<>();
		String query = "select * from student";
		try(Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);){
			
			while(rs.next()) {
				int id = rs.getInt("student_id"); // It's better to use column names
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String course = rs.getString("course");
	            double marks = rs.getDouble("marks");
	            String grade = rs.getString("grade");

	            // 2. Create a new Student object using the constructor
	            Student s = new Student(id,name,age,course,marks,grade);

	            // 3. Add that student object to the list
	            studentList.add(s);
			}
		}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
		return studentList;
	}
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		String query = "select * from student where student_id = ?";
		
		try(Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(query)
			){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery()){
			
			if(rs.next()) {
				int sid = rs.getInt("student_id"); // It's better to use column names
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String course = rs.getString("course");
	            double marks = rs.getDouble("marks");
	            String grade = rs.getString("grade");
	            
	            Student s = new Student(sid, name, age, course, marks, grade);
	            
	            // ADD THIS LINE FOR TESTING:
	            
	            
	            return s;
	          
	            
			}}
			
		}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
		return null;
		
	}







	@Override
	public void updateStudentMarks(int id, double marks) {
		// TODO Auto-generated method stub
		String grade;
		if (marks >= 90) grade = "A";
				else if (marks >= 80) grade = "B";
				else if (marks >= 70) grade = "C";
				else if (marks >= 60) grade = "D";
				else grade = "F";
		String query = "UPDATE student SET marks = ?, grade = ? WHERE student_id = ?";
		try(Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(query)){
			pst.setDouble(1, marks);
			pst.setString(2, grade);
			pst.setInt(3, id);
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
	            System.out.println("Success: Student ID " + id + " updated to Grade " + grade);
	        } else {
	            System.out.println("Warning: No student found with ID " + id);
	        }
		}
		catch(SQLException e) {
			System.out.print(e.toString());
		}
	}







	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String query = "delete from student where student_id = ?";
		try (Connection con = getConnection();
		         PreparedStatement pst = con.prepareStatement(query)) {
		        
		        pst.setInt(1, id);
		        
		        int rowCount = pst.executeUpdate();
		        
		        if (rowCount > 0) {
		            System.out.println("Student with ID " + id + " was deleted successfully.");
		        } else {
		            System.out.println("No student found with ID " + id + ". Nothing was deleted.");
		        }
		        
		    } catch (SQLException e) {
		    	System.out.print(e.toString());
		    }
	}

}


