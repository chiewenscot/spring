package test.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	public HomeController() {
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/restWSDemo", method = RequestMethod.GET)
	public ModelAndView restfulWS(){
		return new ModelAndView("RestfulWSExamples");
	}

}
