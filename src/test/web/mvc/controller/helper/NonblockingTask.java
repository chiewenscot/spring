package test.web.mvc.controller.helper;

import java.util.ArrayList;
import java.util.TimerTask;

import org.springframework.web.context.request.async.DeferredResult;

import test.web.mvc.model.Employee;

public class NonblockingTask extends TimerTask {

	private int id;
	private DeferredResult<NoblockingRestResult> result;
	
	public NonblockingTask(int id, DeferredResult<NoblockingRestResult> deferredResult) {
		this.id = id;
		result = deferredResult;
	}

	@Override
	public void run() {
		if(result.hasResult()) System.out.println("Has result");
		if(result.isSetOrExpired()){
			System.out.println("The requested HTTP call has expired");
		}else{
//			NoblockingRestResult r = (NoblockingRestResult) result.getResult();
			NoblockingRestResult r = new NoblockingRestResult();
			r.setStartTS(System.currentTimeMillis());
			r.setConfigProcessTime(2000);

			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstname("Jimmy");
			employee.setLastname("Tai");
			
			Employee employee1 = new Employee();
			employee1.setId(id+1);
			employee1.setFirstname("Brian");
			employee1.setLastname("Tai");
			
			ArrayList<Employee> list = new ArrayList<Employee>();
			list.add(employee);
			list.add(employee1);
						
			r.setRs(list);
			
			result.setResult(r);
			System.out.println("The requested HTTP call has finished");

		    r.setEndTS(System.currentTimeMillis());
		    r.setTimeElapsed(r.getEndTS()-r.getStartTS());

			r.setStatus(HTTPCallStatus.SUCCESS_FINISHED);
		}

	}

}
