package course;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ManageCourse {
	
	private static SessionFactory factory;
	
	public static void main(String [] args)
	{
		
		
		try {
			
			factory = new Configuration().configure(). buildSessionFactory();
		}catch (Throwable ex) {
			
			System.err.println("Failed to create sessionFactory object. "+ ex);
			
			throw new ExceptionInInitializerError(ex);
		}
		
		ManageCourse MC = new ManageCourse();
		
			
			
			MC.addcourse("kennedy", "Java", 56770);
			MC.addcourse("Morena", "June/July", 100);
			MC.addcourse("Odwa", "SQL", 36770);
			MC.addcourse("Prof", "Hibernate", 5677);
			
			MC.listCourses();
			
			 MC.updateCourse(100);
			
			//MC.deleteCourse(2 );
		 
	}
	

	 private void updateCourse(int salary) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Course course = (Course)session.get(Course.class, salary ); 
	         course.setSalary( salary );
			 session.update(course); 
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
		
	


	
	



	private void deleteCourse(Integer courseId) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Course course = (Course) session.get(Course.class, courseId);
			session.delete(course);
			tx.commit();
		}catch(Exception e) {
			
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		
	}

	}





	private void listCourses()
	{
		
		Session session = factory.openSession();
		
		Transaction tx = null;
		
		try {
			
			tx =session.beginTransaction();
			System.out.println("serse");
			List courses = session.createQuery("FROM Course").list();
			for(Iterator iterator = courses.iterator(); iterator.hasNext();) {
				Course course =(Course) iterator.next();
				
				System.out.println("Course Name: " + course.getCourseName());
				System.out.println("Instructor: " + course.getInstructor());
				System.out.println("Salary: " + course.getSalary());
			}
			tx.commit();
		}catch(Exception e){
			
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	


	private Integer addcourse(String cname,String instruct, int salary) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer courseId = 0;
		
		try {
			
			tx = session.beginTransaction();
			Course course = new Course(courseId, cname, instruct, salary);
			courseId = (Integer) session .save(course);
			tx.commit();
		}catch(Exception e) {
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return courseId;
		
	

	}
	

}
