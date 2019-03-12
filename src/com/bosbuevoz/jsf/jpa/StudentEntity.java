package com.bosbuevoz.jsf.jpa;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="student")
public class StudentEntity {
	
	@PersistenceContext(unitName="JSFJPA")
	EntityManager em;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String firstName;
	private String lastName;
	private String email;
	
	public StudentEntity(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentEntity retrieveStudent() {
		StudentEntity student = em.find(StudentEntity.class, '1');
		
		return student;
	}
}
