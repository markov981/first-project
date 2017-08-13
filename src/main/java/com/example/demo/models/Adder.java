package com.example.demo.models;

public class Adder {
	
	double s1; double s2;
	
	public Adder(double first, double second) 
	{
		s1 = first;
		s2 = second;}
	
	
	public double sum() { return s1 + s2;}
	public String opr() { return "Addition";}
}
