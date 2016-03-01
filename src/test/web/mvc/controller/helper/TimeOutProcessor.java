package test.web.mvc.controller.helper;

public class TimeOutProcessor implements Runnable {

	public TimeOutProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Timeout occurred.");
	}

}
