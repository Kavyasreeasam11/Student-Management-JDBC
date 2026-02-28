package Student;

public class Student {
	private int sid;
	private String name;
	private int age;
	private double marks;
	private String course;
	private String grade;
	public int getSid() {
		return sid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid,String name, int age, String course,double marks,  String grade) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		
		this.course = course;
		this.marks = marks;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", marks=" + marks + ", course=" + course
				+ ", grade=" + grade + "]";
	}

	
	
	
	
}
