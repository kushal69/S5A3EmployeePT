package com;

import java.util.Scanner;

//	Main Class to process Employee details
public class Compute_Salary {

	//	Main Method
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);	//	Scanner object to get the user input
		//	Few instance variables
		String typeOfEmployee = "";
		String leaveConfirmation = "";
		@SuppressWarnings("unused")
		boolean leaveAvailed = false;
		int no_of_leaves;
		char type_of_leave;

		System.out.print("Enter the type of employee (Permanent / Temporary) ? - ");	//	For to know the type of Employee to process
		typeOfEmployee = userInput.nextLine();

		//	Based on the type of Employee to process
		if (typeOfEmployee.equalsIgnoreCase("Permanent")) {
			Employee pEmp = new PermanentEmp();		//	Creating the Permanent Employee Object

			System.out.print("Enter Employee Name : ");
			pEmp.empName = userInput.nextLine();	//	Taking the Employee Name

			System.out.print("Enter Employee Id : ");
			pEmp.empId = userInput.nextInt();		//	Taking the Employee Id

			System.out.println("Enter the Leaves details");
			System.out.print("Casual Leave : ");
			pEmp.casual_leave = userInput.nextInt();	//	Taking the Casual leave no.

			System.out.print("Sick Leave : ");
			pEmp.sick_leave = userInput.nextInt();		//	Taking the Sick leave no.

			System.out.print("Paid Leave : ");
			pEmp.paid_leave = userInput.nextInt();		//	Taking the Paid leave no.

			pEmp.calculate_balance_leaves();			//	Calculating no. of leaves based on the data taken from the user

			System.out.print("Do you need to avail Leaves (Y/N) ? ");
			userInput.nextLine();
			leaveConfirmation = userInput.nextLine();	//	Getting confirmation from the user whether he/she wants to avail leaves

			if (leaveConfirmation.equalsIgnoreCase("Y")) {		//	Processing the leave avail by taking no. of leaves and type of leave from the user
				System.out.print("Enter the no. of Leaves : ");
				no_of_leaves = userInput.nextInt();

				System.out.print("Enter the type of Leave (C/S/P - Casual/Sick/Paid leaves respectively) : ");
				userInput.nextLine();
				type_of_leave = userInput.nextLine().charAt(0);
				leaveAvailed = pEmp.avail_leave(no_of_leaves, type_of_leave);	//	Calculating the balance leave after leave avail
			} else {
				System.out.println("Leaves have not availed");
			}
			//	Taking the Salary details from the User
			System.out.println("--------------------------------------------------------------");
			System.out.println("Enter the Salary details to compute : ");
			System.out.print("Enter the Basic Salary : ");
			pEmp.basic = userInput.nextDouble();		//	Getting the basic salary

			System.out.print("Enter the HRA Amount : ");
			pEmp.hra = userInput.nextDouble();			//	Getting the HRA amount

			pEmp.calculate_salary();	//	Calculating the salary with PFA deduction and printing the same

			System.out.println("Total Salary of the Employee " + pEmp.empName + " - " + pEmp.total_salary);
			System.out.println("Deductions under PF is - " + pEmp.pfa);

		} else if (typeOfEmployee.equalsIgnoreCase("Temporary")) {	//	Below code is similar to the above but for the Temporary Employee
			Employee pEmp = new TemporaryEmp();

			System.out.print("Enter Employee Name : ");
			pEmp.empName = userInput.nextLine();

			System.out.print("Enter Employee Id : ");
			pEmp.empId = userInput.nextInt();

			System.out.println("Enter the Leaves details");
			System.out.print("Casual Leave : ");
			pEmp.casual_leave = userInput.nextInt();

			System.out.print("Sick Leave : ");
			pEmp.sick_leave = userInput.nextInt();

			System.out.print("Paid Leave : ");
			pEmp.paid_leave = userInput.nextInt();

			pEmp.calculate_balance_leaves();

			System.out.print("Do you need to avail Leaves (Y/N) ? ");
			userInput.nextLine();
			leaveConfirmation = userInput.nextLine();

			if (leaveConfirmation.equalsIgnoreCase("Y")) {
				System.out.print("Enter the no. of Leaves : ");
				no_of_leaves = userInput.nextInt();

				System.out.print("Enter the type of Leave (C/S/P - Casual/Sick/Paid leaves respectively) : ");
				userInput.nextLine();
				type_of_leave = userInput.nextLine().charAt(0);
				leaveAvailed = pEmp.avail_leave(no_of_leaves, type_of_leave);
			} else {
				System.out.println("Leaves have not availed");
			}

			System.out.println("--------------------------------------------------------------");
			System.out.println("Enter the Salary details to compute");
			System.out.print("Enter the Basic Salary : ");
			pEmp.basic = userInput.nextDouble();

			System.out.print("Enter the HRA Amount : ");
			pEmp.hra = userInput.nextDouble();

			pEmp.calculate_salary();

			System.out.println("Total Salary of the Employee " + pEmp.empName + " - " + pEmp.total_salary);
			System.out.println("Deductions under PF is - " + pEmp.pfa);
		} else {
			System.out.println("Enter the Correct Employee type as given in the statement");
		}

		userInput.close();
	}

}
