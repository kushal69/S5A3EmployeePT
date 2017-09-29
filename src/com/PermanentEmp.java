package com;

//	A Child class where it is extending the Parent Employee Class
public class PermanentEmp extends Employee {

	//	Method to print leave details
	void print_leave_details() {
		System.out.println("Leave details of - " + empName);
		System.out.println("Casual Leave - " + casual_leave);
		System.out.println("Sick Leave - " + sick_leave);
		System.out.println("Paid Leave - " + paid_leave);
		System.out.println("-----------------------------------");
		System.out.println("Balance Leave - " + total_leaves);
	}

	@Override	//	Method overriding its parent implementation
	void calculate_balance_leaves() {
		total_leaves = casual_leave + sick_leave + paid_leave;	//	Calculating the balance no. leaves
		print_leave_details();	//	Method call to print the leave details after calculation
	}

	@Override	//	Method overriding its parent implementation and to give the employee to avail leave option and re-calculate the balance leaves
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		boolean aL = false;
		//	Calculation is based on the type of leave
		if (type_of_leave == 'C') {	
			if (no_of_leaves <= casual_leave) {
				casual_leave = casual_leave - no_of_leaves;		//	Updating the leave after validation if have enough leaves to atain or not
				System.out.println("You have availed the leave below are the details of the leaves");
				System.out.println("--------------------------------------------------------------");
				calculate_balance_leaves();	//	Calculating the leaves again
				aL = true;
			} else {
				System.out.println("You don't have specified no. of leaves which you can atain under the category - Casual Leave");
			}
		} else if (type_of_leave == 'S') {
			if (no_of_leaves <= sick_leave) {
				sick_leave = sick_leave - no_of_leaves;
				System.out.println("You have availed the leave below are the details of the leaves");
				System.out.println("--------------------------------------------------------------");
				calculate_balance_leaves();
				aL = true;
			} else {
				System.out.println("You don't have specified no. of leaves which you can atain under the category - Sick Leave");
			}
		} else if (type_of_leave == 'P') {
			if (no_of_leaves <= paid_leave) {
				paid_leave = paid_leave - no_of_leaves;
				calculate_balance_leaves();
				System.out.println("You have availed the leave below are the details of the leaves");
				System.out.println("--------------------------------------------------------------");
				aL = true;
			} else {
				System.out.println("You don't have specified no. of leaves which you can atain under the category - Paid Leave");
			}
		}
		return aL;
	}

	@Override 	//	Method overriding its parent implementation to calculate the salary of the employee
	void calculate_salary() {
		System.out.println("--------------------------------------------------------------");
		pfa = ((hra * 12) / 100 ) + ((basic * 50) / 100) ;	// Formula to calculate the PFA
		total_salary = basic + hra - pfa;	//	Formula to calculate Total Salary
	}
}
