package test.web.mvc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author	Jimmy
 * 
 * Employee object is a model object of MVC pattern
 * 
 * */

@XmlRootElement(name = "employee")
public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	
	public Employee() {
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	@XmlElement
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@XmlElement
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
