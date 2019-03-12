package com.bosbuevoz.jsf.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//import com.bosbuevoz.jsf.jpa.StudentDbUtil;

@Entity
@ManagedBean//register the class student as JSF resource
@RequestScoped// creates an instance of Student for each user request
public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	
	public List<Student> student = new ArrayList<Student>();
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{
		if(value == null)
		{
			return;
		}
		
		String data = value.toString();
		
		if(!data.endsWith(".com"))
		{
			FacesMessage message= new FacesMessage("Emails should end with .com");
			throw new ValidatorException(message);
		}
	}
	
}