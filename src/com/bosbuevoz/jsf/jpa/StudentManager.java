package com.bosbuevoz.jsf.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.bosbuevoz.jsf.jpa.StudentDbUtil; 

@ManagedBean//register the class student as JSF resource
@SessionScoped// creates an instance of Student for each user request

public class StudentManager {

	private List<Student> students;
	
	public StudentManager() {
		try{
			System.out.println("session scope");
			students = new ArrayList<Student>();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadStudents() {
		students.clear();
		
		try {
			students = StudentDbUtil.getStudents();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String addStudent(Student stu) {
		StudentDbUtil.addStudent(stu);
		return "List-students?faces-redirect=true";
	}
	
	/*public String loadStudent(int id) {
		int id2 = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedStudentId"));
		
		Student s = StudentDbUtil.fetchStudent(id2);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = ec.getRequestMap();
		requestMap.put("student", s);
		
		return "List-students?faces-redirect=true";
	}*/
	
	public String updateStudent(Student stu) {
		StudentDbUtil.updateStudent(stu);
		return "List-students?faces-redirect=true";
	}
	
	public String deleteStudent(int id) {
		StudentDbUtil.deleteStudent(id);
		return "Add-students?faces-redirect=true";
	}
}
