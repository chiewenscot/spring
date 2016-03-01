package test.web.mvc.controller.helper;

public class CompletionProcessor implements Runnable {

	public CompletionProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Task Completed.");
	}

}
