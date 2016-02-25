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

	@RequestMapping(value = "Employee/getTestCases/{testcases}", method = RequestMethod.GET)
	public void getFile(@PathVariable("testcases") String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		fileName = "/postman/SpringWeb.json.postman_collection";
		// get absolute path of the application
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file
		String fullPath = appPath + fileName;
		File downloadFile = new File(fullPath);
		try (FileInputStream inputStream = new FileInputStream(downloadFile);
				OutputStream outStream = response.getOutputStream()) {

			// get MIME type of the file
			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null) {
				// set to binary type if MIME mapping not found
				mimeType = "application/octet-stream";
			}
			System.out.println("MIME type: " + mimeType);

			// set content attributes for the response
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			// set headers for the response
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// get output stream of the response
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

}
