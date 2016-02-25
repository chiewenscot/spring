<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jimmy Restful WS demo</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script language="javascript">
	$(document)
			.ready(
					function() {
						$('input')
								.click(
										function(e) {
											alert("Hello");
											//e.preventDefault();
											window.location.href = "https://raw.githubusercontent.com/chiewenscot/FileServer/master/postman/SpringWeb.json.postman_collection";
										});
					});
</script>
</head>
<body>
	<input id="dwnloadFile" type="button" value="Download" onclick="">
	<a
		href="https://raw.githubusercontent.com/chiewenscot/FileServer/master/postman/SpringWeb.json.postman_collection"
		target="_blank">Download</a>
	<h1>Restful WebServices by Example</h1>
	<h2>About the demo</h2>
	<p>This simple Restful WebServices example contains couple of
		source code files for demonstrating Restful WebService implementation
		using SpringFramework 4 technology.</p>
	<h2>Available functions are</h2>
	<ul>
		<li>HTTP GET for looking for an Employee from the server</li>
		<li>HTTP POST for creating an Employee in the server</li>
		<li>HTTP PUT for updating an Employee in the server</li>
		<li>HTTP DELETE for deleting an Employee in the server</li>
	</ul>
	<h2>How to run this demo</h2>
	<p>
		This demo has pre-defined an Employee object as a MVC model and as a
		XML document used in communications. The object simply contains an
		integer attribute id as primary key, a first name and a last name
		attribute. You will need a Restful WebServices Client utility for
		running the tests. The client utility I used for testing was called
		Postman where you could download from the Internet for free at <a
			target="_blank" href="https://www.getpostman.com/">https://www.getpostman.com/</a>.
		I have also provided a pre-built test case file (Postname Collection)
		which can be uploaded onto the Postman test tool to execute directly
		on the testing tool. Please note the output of the tests can be
		formated in either JSon or XML formats by changing "Accept" HTTP
		header attribute value.
	</p>
	<ul>
		<li>Format in JSon=>Accept:"application/json"</li>
		<li>Format in XML=>Accept:"application/xml"</li>
	</ul>
	<h2>Requirements to run this example</h2>
	<ul>
		<li>JDK 8</li>
		<li>Any J2EE Server (I was running this example using WildFly V10 application server)</li>
		<li>Spring Framework Version 4.X</li>
		<li>A WAR package of this example</li>
	</ul>
	<h2>The Restful WebServices Controller Example Code</h2>
	<pre>
	package test.web.mvc.controller;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import javax.servlet.ServletContext;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	import test.web.mvc.model.Employee;

	/**
	 * @author JTai
	 * 
	 *         GreetingController is an Spring MVC Restful Controller. The Restful
	 *         Controller was provided since Spring 4 for simplify implemention of
	 *         Restful Webservices compare to its previous verisons.
	 * 
	 */
	
	@RestController
	public class EmployeeController {
	
		@Autowired
		ServletContext context;
	
		public EmployeeController() {
		}
	
		/**
		 * This method is a simple controller action accepting HTTP GET calls for
		 * retrieving an employee object. The employee object will be returned in
		 * either JSon or XML format. You may specify your desire format in header
		 * 
		 * @param id
		 *            the ID of the employee that you are looking for *
		 * @return employee object
		 */
		@RequestMapping(value = "/Employee/findByPK/{id}", method = RequestMethod.GET, produces = {
				MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public Employee findByPK(@PathVariable("id") int id) {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstname("Jimmy");
			employee.setLastname("Tai");
			return employee;
		}
	
		/**
		 * This method is a simple controller action accepting HTTP POST calls for
		 * creating an employee object. The employee object will be returned in
		 * either JSon or XML format for demo purpose.
		 * 
		 * @param e
		 *            the employee object you would like to created
		 * @return employee object
		 */
		@RequestMapping(value = "/Employee/create", method = RequestMethod.POST, produces = {
				MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public Employee createEmployee(@RequestBody Employee employee) {
			return employee;
		}
	
		/**
		 * This method is a simple controller action accepting HTTP PUT calls for
		 * updating an employee object. The employee object will be returned in
		 * either JSon or XML format for demo purpose.
		 * 
		 * @param e
		 *            the employee object you would like to created
		 * @return employee object
		 */
		@RequestMapping(value = "/Employee/update", method = RequestMethod.PUT, produces = {
				MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public Employee updateEmployee(@RequestBody Employee employee) {
			return employee;
		}
	
		/**
		 * This method is a simple controller action accepting HTTP DELETE calls for
		 * deleting an employee by providing the employee ID. The employee object
		 * will be returned in either JSon or XML format for demo purpose.
		 * 
		 * @param id
		 *            the ID of the employee you wish to delete
		 * @return employee object
		 */
		@RequestMapping(value = "/Employee/delete", method = RequestMethod.DELETE, produces = {
				MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public Employee createEmployee(@RequestParam("id") int id) {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstname("Jimmy");
			employee.setLastname("Tai");
			return employee;
		}
	}
	</pre>
</body>
</html>