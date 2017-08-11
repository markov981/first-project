package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.models.Adder;


@Controller
@RequestMapping({"/math"})
public class MathController {

	@GetMapping("adder")
	public String showAdd() { return "helloworld/adder-form"; }
	
	@PostMapping("adder") 
	public String addTwoNumbers(
			@RequestParam(name = "left") int first, 
			@RequestParam(name = "right") double second, 
			Model model) 
	{
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	


	/*
	 * @PostMapping("subtr") public String subtrTwoNumbers(
	 * 
	 * @RequestParam(name="left") int first,
	 * 
	 * @RequestParam(name="right") double second, Model model) { Subtr subtr = new
	 * Subtr(first, second); model.addAttribute("sum", subtr.subtr()); return
	 * "helloworld/sum-result";}
	 */
}
