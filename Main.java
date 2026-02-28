package Main;
import java.util.*;
import Student.Student;
import DAO.StudentDao;
import DAO.studentimp;
public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		StudentDao dao = new studentimp();
		
		while (true) {
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
            	System.out.println("Enter student id1");
            	int sid = sc.nextInt();
            	sc.nextLine();
            	System.out.println("Enter student name");
            	String sname = sc.nextLine();
            	System.out.println("Enter student age");
            	int sage = sc.nextInt();
            	System.out.println("Enter student marks");
            	double smarks = sc.nextDouble();
            	sc.nextLine();
            	System.out.println("Enter student course");
            	String scourse = sc.nextLine();
            	String sgrade = calGrade(smarks);
            	Student sobj = new Student(sid,sname,sage,scourse,smarks,sgrade);
            	dao.addStudent(sobj);
            	break;
            
            case 2:
            	System.out.println("Viewing all student details");
            	System.out.println("--- All Student Details ---");
                List<Student> list = dao.getAllStudents();
                for (Student s : list) {
                    System.out.println(s.toString()); // This uses your Student's toString() method
                }
            	break;
            case 3:
            	System.out.println("Enter student id to search");
            	int fid = sc.nextInt();
            	Student found = dao.getStudentById(fid);
            	if (found != null) {
                    // Stop using 'System.out.println(found)'
                    // Use the getters manually!
                    String result = "ID: " + found.getSid() + 
                                    " | Name: " + found.getName() + 
                                    " | Age: " + found.getAge() + 
                                    " | Course: " + found.getCourse() + 
                                    " | Marks: " + found.getMarks() + 
                                    " | Grade: " + found.getGrade();
                    System.out.println("Student Found: " + result);
                } else {
                    System.out.println("Student not found.");
                }
            	break;
            case 4:
            	System.out.println("Enter student id to update marks");
            	int uid = sc.nextInt();
            	System.out.println("Enter updated marks");
            	double umarks = sc.nextDouble();
            	dao.updateStudentMarks(uid, umarks);
            	break;
            case 5:
            	System.out.println("Enter id to delete");
            	System.out.println("This action is permanent!! You cant get this back");
            	int did = sc.nextInt();
            	dao.deleteStudent(did);
            	break;
            case 6:
            	System.out.println("Exiting... Goodbye!");
                sc.close();
                System.exit(0);
            default:
            	System.out.println("Invalid choice!");
            	
            }
            
		
	
}}
	public static String calGrade(double marks) {
		String grade;
		if (marks >= 90) grade = "A";
		else if (marks >= 80) grade = "B";
		else if (marks >= 70) grade = "C";
		else if (marks >= 60) grade = "D";
		else grade = "F";
		return grade;
	}
	}
