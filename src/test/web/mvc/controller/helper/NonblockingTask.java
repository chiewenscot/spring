package test.web.mvc.controller.helper;

import java.util.ArrayList;
import java.util.TimerTask;

import org.springframework.web.context.request.async.DeferredResult;

import test.web.mvc.model.Employee;

public class NonblockingTask extends TimerTask {

	private DeferredResult<NoblockingRestResult> result;
	
	public NonblockingTask(DeferredResult<NoblockingRestResult> deferredResult) {
		result = deferredResult;
	}

	@Override
	public void run() {
		if(result.isSetOrExpired()){
			System.out.println("The requested HTTP call has expired");
		}else{
			Employee employee = new Employee();
			employee.setId(1);
			employee.setFirstname("Jimmy");
			employee.setLastname("Tai");
			
			ArrayList<Employee> list = new ArrayList<Employee>();
			list.add(employee);
			
			NoblockingRestResult r = new NoblockingRestResult();//) result.getResult();
			
			r.setStatus(HTTPCallStatus.SUCCESS_FINISHED);
			r.setRs(list);
			
			result.setResult(r);
			System.out.println("The requested HTTP call has finished");
		}

	}

}
