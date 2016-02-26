package test.web.mvc.controller.helper;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import test.web.mvc.model.Employee;

@XmlRootElement
public class NoblockingRestResult {

	@XmlElement
	private HTTPCallStatus status;

	@XmlElement
	private List<Employee> rs;
	
	public NoblockingRestResult() {
	}

	
	public HTTPCallStatus getStatus() {
		return status;
	}

	public void setStatus(HTTPCallStatus status) {
		this.status = status;
	}

	public List<Employee> getRs() {
		return rs;
	}

	public void setRs(List<Employee> rs) {
		this.rs = rs;
	}
}
