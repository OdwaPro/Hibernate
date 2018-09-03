package course;


public class Course {
	
	private int courseId;
	private String course_name;
	
private String instructor;
	private int salary; 
	
	public Course() {}
	
	public Course(int idCourse ,String cname, String instruct, int salary){
		
		this.courseId = idCourse;
		this.course_name = cname;
		this.instructor = instruct;
		this.salary = salary;
		
	}
	
	public void setCourseId(int idCourse) {
		
		this.courseId = idCourse;
	}
	
	public int getCourseId() {
		
		return courseId;
	}
	public void setCourseName(String Course_name) {
		
		this.course_name = Course_name;
	}
	
	public String getCourseName() {
		
		return course_name;
	}
	
	public void setInstructor(String Instructor) {
		
		this.instructor = Instructor;
	}
	
	public String getInstructor() {
		
		return instructor;
	}
	
	public void setSalary(int Salary) {
		
		this.salary = Salary; 
	}
	
	public int getSalary() {
		
		return salary;
	}

}
