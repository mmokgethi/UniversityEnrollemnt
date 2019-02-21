package bbd.studentroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bbd.studentroll.Course;
import bbd.studentroll.Student;


public class StudentTest {


    Course c   = null;
    Student student1 = null;
	Student student2 = null;
	Student student3 = null;
	Student student4 = null;
	
	@Before
	public void setUp()
	{
		student1 = new Student("Modisa", 12, "19930723");
		student2 = new Student("Kenny", 11, "19931809");
		student3 = new Student("Aobakwe", 12, "19951002");
		student4 = new Student("Rudolf", 13, "19931212");
		c  = new Course("Java", 2);
	}
	
	@Test
	public void testStudent() {
		
		assertEquals("Modisa", student1.getName());
		assertEquals("19930723", student1.getDob());
		assertEquals("Kenny", student2.getName());
		assertEquals("19931809", student2.getDob());
		
		assertEquals("Aobakwe", student3.getName());
		assertEquals("19951002", student3.getDob());
	}
	
	@Test
	public void testCourse(){
		
		Course cr =  Mockito.mock(Course.class);
		Mockito.when(cr.getName()).thenReturn("LOL");
		
		assertEquals("LOL", cr.getName());
		
		assertEquals("Java", c.getName());
		assertEquals(2, c.getCap());
		
		assertTrue(c.enrollStudent(student1));
		assertTrue(c.enrollStudent(student2));
		assertFalse(c.enrollStudent(student3));
		
		String stud1 = c.getStudents().get(0).getName();
		String stud2 = c.getStudents().get(1).getName();
		
		assertEquals("Modisa", stud1);
		assertEquals("Kenny", stud2);
		
		assertFalse(c.unenrollStudent(student3));
		assertTrue(c.unenrollStudent(student1));
		assertTrue(c.unenrollStudent(student2));
		
	}
	

	public void reset()
	{
		student1 = null;
		student2 = null;
		student3 = null;
		student4 = null;
		c  = null; 
	}

}
