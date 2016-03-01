package test.web.mvc.controller.helper;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import test.web.mvc.model.Employee;

@XmlRootElement
public class NoblockingRestResult {

//	@XmlElement
	private long startTS;

//	@XmlElement
	private long endTS;
	
//	@XmlElement
	private long timeElapsed;
	
//	@XmlElement
	private HTTPCallStatus status;

//	@XmlElement
	private List<Employee> rs;
	
//	@XmlElement
	private long configProcessTime;
	
	public NoblockingRestResult() {
	}

	
	public HTTPCallStatus getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(HTTPCallStatus status) {
		this.status = status;
	}

	public List<Employee> getRs() {
		return rs;
	}

	@XmlElement
	public void setRs(List<Employee> rs) {
		this.rs = rs;
	}
	
	public long getStartTS() {
		return startTS;
	}


	@XmlElement
	public void setStartTS(long startTS) {
		this.startTS = startTS;
	}


	public long getEndTS() {
		return endTS;
	}


	@XmlElement
	public void setEndTS(long endTS) {
		this.endTS = endTS;
	}


	public long getTimeElapsed() {
		return timeElapsed;
	}


	@XmlElement
	public void setTimeElapsed(long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}


	public long getConfigProcessTime() {
		return configProcessTime;
	}


	@XmlElement
	public void setConfigProcessTime(long configProcessTime) {
		this.configProcessTime = configProcessTime;
	}
}
