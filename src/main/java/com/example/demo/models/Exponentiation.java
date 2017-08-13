package com.example.demo.models;

public class Exponentiation 
{
	double s1; double s2;
	
	public Exponentiation(double first, double second) 
	    { s1 = first; s2 = second;}
	
	// Math.pow(number, exponent);
	public double expn()  
		{ return Math.pow(s1, s2); }
}