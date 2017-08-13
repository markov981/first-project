package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.models.Adder;
import com.example.demo.models.Division;
import com.example.demo.models.Exponentiation;
import com.example.demo.models.Modulo;
import com.example.demo.models.Multip;
import com.example.demo.models.Subtr;


@Controller
@RequestMapping( {"/", "/calc"} )
public class CalcController 
{
	//private String title;
	//public CalcController() {  title = "Our Cool Calculator";  }
	
	
	@GetMapping("enter")
	public String index()   {  return "calc/index-calc-DN";  }
	

	@PostMapping("enter")
	public String selectOperation(
		@RequestParam(name = "left")  double first, 
		@RequestParam(name = "right") double second,
		String 								 operation,
		Model                                model) 
	{
		// Used by "M+" button: "Recall the last result from memory"
		double memResult = 0.0;
		model.addAttribute("mem", memResult);
		
		
		if (operation.equals("sub")) {
				Subtr sub = new Subtr(first, second);
				model.addAttribute("val", sub.subtr()); 
				model.addAttribute("oper", "Subtraction");} 
		
		else if (operation.equals("add")) { 
				Adder add = new Adder(first, second);
				memResult = add.sum();
				model.addAttribute("val", add.sum()); 
				model.addAttribute("oper", add.opr());}
		
		else if (operation.equals("div")) { 
				Division div = new Division(first, second);
				model.addAttribute("val", div.divn());	
				model.addAttribute("oper", "Division");}
		
		else if (operation.equals("mlt")) { 
				Multip mlt = new Multip(first, second);
				model.addAttribute("val", mlt.mult()); 
				model.addAttribute("oper", "Multiplication");}
		
		else if (operation.equals("mod")) { 
				Modulo mod = new Modulo(first, second);
				model.addAttribute("val", mod.modl()); 
				model.addAttribute("oper", "Find Remainder");}
		
		else if (operation.equals("exp")) { 
				Exponentiation exp = new Exponentiation(first, second);
				model.addAttribute("val", exp.expn()); 
				model.addAttribute("oper", "Raise X to the power of y");}
		
		else if (operation.equals("mem")) {
			    model.addAttribute("val", memResult);
			    model.addAttribute("mem", memResult);
			    model.addAttribute("oper", "use result from the last calculation");}

		return "calc/calc-result-DN";
	}		
}


