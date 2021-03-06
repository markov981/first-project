package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtr;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;


@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	public HelloWorldController() {  title = "Hello Java and Spring!";  }
	
	
	// default for "/" path
	@GetMapping("")
	public String index() {  return "helloworld/index";  }
	
	
	// no need to have (name="left") as both the param & HTML var is = message
	@GetMapping("message-path")  //URL to which the form submits
	public ModelAndView messageMethod(
		   @RequestParam(required=false, defaultValue="«silence»") String submittedMessage) {
		
		// Find this file ../templates/helloworld/message.html
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		Yeller yel1 = new Yeller();
		mv.addObject("messageToBeShown", yel1.caps(submittedMessage));
		return mv;}
	
	
	@GetMapping("whisper-path")  // URL to which the form submits 
	public ModelAndView makeThingsQuiet(
			// defaultValue= (String), use when the request parameter is not provided or has an empty value
			// Providing a default value implicitly sets 'required' to false.
			@RequestParam(required=false, defaultValue="«shhhhh»") String submittedMessage) 
	{
		ModelAndView mv = new ModelAndView("helloworld/message");
		Whisperer wsp = new Whisperer();
		mv.addObject("title", title);
		mv.addObject("messageToBeShown", wsp.lrCase(submittedMessage));
		return mv;}
	
	
	@GetMapping("say-something")  
	public String makeAChoice(
			String submittedMessage, 
			String speechChoice, 
			Model  model) 
	{
		if (speechChoice.equals("yell")) 
		{  
			Yeller yel2 = new Yeller();
			String loud = yel2.caps(submittedMessage);
			model.addAttribute("output", loud);
		}
		else 
		{
			Whisperer wsp2 = new Whisperer();
			String quiet = wsp2.lrCase(submittedMessage);
			model.addAttribute("output", quiet);
		}		
		return "helloworld/mixed-messages";
	}
	 	
}
