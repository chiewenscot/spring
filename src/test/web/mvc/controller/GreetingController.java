package test.web.mvc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.web.mvc.model.Employee;

@RestController
public class GreetingController {

	public GreetingController() {
	}
	
	//@//ResponseBody
	@RequestMapping("/greeting")
	public Employee getSearchResultViaAjax() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstname("Jimmy");
		employee.setLastname("Tai");
		return employee;
	}
	
	@RequestMapping(value="/greeting1", method = RequestMethod.GET, produces = "application/json")
	public Employee getSearchResultViaAjax1(@RequestParam("id") int id) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname("Brain");
		employee.setLastname("Tai");
		return employee;
	}
	
	@RequestMapping(value="/greeting2", method = RequestMethod.POST, produces = "application/json")
	public Employee getSearchResultViaAjax2(@RequestBody Employee e) {
		Employee employee = new Employee();
		employee.setId(e.getId());
		employee.setFirstname("Brain");
		employee.setLastname("Tai");
		return employee;
	}

}
