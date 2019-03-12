package com.bosbuevoz.jsf.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bosbuevoz.jsf.jpa.Student;


public class StudentDbUtil {
	private static final String PERSISTENCE_UNIT_NAME = "JSFJPA";
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	private static EntityManager em;
	
		public static List<Student> getStudents() {	
		System.out.println("test");
		try {
		List<Student> Students = new ArrayList<Student>(); 
		em = factory.createEntityManager();
		Query query = em.createQuery("SELECT s FROM Student AS s");
		Students = query.getResultList();
		return	Students;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	/*
	private static Connection getConnexion() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "Maximedu33360");
        return con;
    }
	
	
    public static List<Student> getStudents() {

        List<Student> students = new ArrayList<Student>();
        try {

        Connection con = getConnexion();
        Statement stmt = con.createStatement();

        ResultSet rset = stmt.executeQuery("SELECT * FROM student");

        while (rset.next()) {
            Student student = rsetToStudent(rset);
            students.add(student);
        }

        stmt.close();
        con.close();
        return students;
        }
        catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
        
    }
	
	private static Student rsetToStudent(ResultSet rset) throws SQLException {
        Integer id = rset.getInt("id");
        String first_name = rset.getString("first_name");
        String lastName = rset.getString("lastName");
        String email = rset.getString("email");

        Student student = new Student(id, first_name, lastName, email);
        return student;
    }*/
	
	public static void addStudent(Student s) {
		em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public static Student fetchStudent(int id) {
		em = factory.createEntityManager();
		Student s = em.find(Student.class, id);
		
		if(s != null)
		{
			return s;
		}
		else {
			return null;
		}
	}
	
	public static void updateStudent(Student s) {
		em = factory.createEntityManager();
		
		Student stud = em.find(Student.class, s.getId());
		
		em.getTransaction().begin();
		stud.setFirstName(s.getFirstName());
		stud.setLastName(s.getLastName());
		stud.setEmail(s.getEmail());
		
		em.getTransaction().commit();
	}
	
	public static void deleteStudent(int id) {
		em = factory.createEntityManager();
		
		Student s = em.find(Student.class, id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
	}
}
