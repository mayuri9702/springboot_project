package com.citi.ex.dto;

// will accept all args in a constructor
import lombok.AllArgsConstructor;
// Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, and more
import lombok.Data;
// will accept no args in constructor
import lombok.NoArgsConstructor;	
//  both constructors are public in nature

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Person {

	private int personID;
	private String firstName;
	private String lastName;
	private String panCard;
	private String aadharCard;
	
	
	
}
