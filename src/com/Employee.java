package com;

//	Main Employee Class with some properties and methods where the sub classes can use
public class Employee {
	int empId;
	String empName;
	int total_leaves;
	double total_salary;

	int paid_leave, sick_leave, casual_leave;
	double basic, hra, pfa;

	void calculate_balance_leaves() {
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		boolean aL = false;
		return aL;
	}

	void calculate_salary() {
	};
}
