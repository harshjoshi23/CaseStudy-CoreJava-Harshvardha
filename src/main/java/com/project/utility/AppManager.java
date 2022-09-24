package com.project.utility;

import java.time.LocalDate;
import java.util.Scanner;

import com.project.model.Employee;
import com.project.services.EmployeeService;

public abstract class AppManager {
	private static EmployeeService service = new EmployeeService();
	private static Scanner sc = new Scanner(System.in);

	public static void availableOptions() {
		System.out.println("Choose the option from 1 to 8!");
		System.out.println("1. Employee Details \r\n" + "\r\n" + "2) Employee list by First Name . \r\n" + "\r\n"
				+ "3) Employee list by First Name and PhoneNo \r\n" + "\r\n"
				+ "4) Update the email and phoneNumber with Email \r\n" + "\r\n" + "5) Delete Details by firstName \r\n"
				+ "\r\n" + "6) List with first name and email address whose birthday falls on the date \r\n" + "\r\n"
				+ "7) Get the list of employees with their firstName and phone Number whose Wedding Anniversary falls on the given date \r\n"
				+ "\r\n" + "8) Exit");
	}

	public static void wrongChoiceAlert() {
		System.out.println("--------Learn how to put wrong input------");
	}

	public static void yourChoice1() {

		System.out.println("Employee's firstName -> ");
		String firstName = sc.nextLine();

		System.out.println("Employee's lastName");
		String lastName = sc.nextLine();

		System.out.println("Employee's address");
		String address = sc.nextLine();

		System.out.println("Employee's email");
		String email = sc.nextLine();

		System.out.println("Employee's phone number :");
		Long phoneNumber = Long.parseLong(sc.nextLine());

		System.out.println("Enter employee's date of birth in dd/mm/yyyy format");
		String dateOfBirth = sc.nextLine();
		String[] parts = dateOfBirth.split("/");
		LocalDate dateOfBirthActual = LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]),
				Integer.parseInt(parts[0]));

		System.out.println("Enter employee's wedding date in dd/mm/yyyy format");
		String dateOfWedding = sc.nextLine();
		parts = dateOfWedding.split("/");
		LocalDate dateOfWeddingActual = LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]),
				Integer.parseInt(parts[0]));
		service.addEmployee(
				new Employee(firstName, lastName, address, email, phoneNumber, dateOfBirthActual, dateOfWeddingActual));
	}

	public static void yourChoice2() {
		System.out.println("Enter employee's firstName");
		String firstName = sc.nextLine();
		service.getEmployeesByFirstName(firstName);
	}

	public static void yourChoice3() {
		service.getEmployeesWithFirstNameAndPhoneNumber();
	}

	public static void yourChoice4() {
		System.out.println("Enter the email of the employee that you want to modify");
		String oldEmail = sc.nextLine();
		System.out.println("Now enter new mobile number");
		Long phoneNumber = Long.parseLong(sc.nextLine());
		System.out.println("Enter new email id");
		String newEmail = sc.nextLine();
		service.updateEmailAndPhoneNumberByEmail(newEmail, phoneNumber, oldEmail);
	}

	public static void yourChoice5() {
		System.out.println("Enter firstName");
		String firstName = sc.nextLine();
		service.deleteEmployeeByFirstName(firstName);
	}

	public static void yourChoice6() {
		System.out.println("Enter month number");
		int monthOfTheYear = sc.nextInt();
		System.out.println("Enter day number of that month");
		int dayOfTheMonth = sc.nextInt();
		service.getEmployeesFirstNameAndEmailByBirthDate(dayOfTheMonth, monthOfTheYear);
	}

	public static void yourChoice7() {
		System.out.println("Enter month number");
		int monthOfTheYear = sc.nextInt();
		System.out.println("Enter day number of that month");
		int dayOfTheMonth = sc.nextInt();
		service.getEmployeesFirstNameAndPhoneNumberByWeddingDate(dayOfTheMonth, monthOfTheYear);
	}

	public static boolean evaluteChoice(int choice) {
		switch (choice) {
		case 1:
			yourChoice1();
			break;
		case 2:
			yourChoice2();
			break;
		case 3:
			yourChoice3();
			break;
		case 4:
			yourChoice4();
			break;
		case 5:
			yourChoice5();
			break;
		case 6:
			yourChoice6();
			break;
		case 7:
			yourChoice7();
			break;
		case 8: // exit case
			System.out.println("Thank you! Turning off...");
			System.exit(0);
		default:
			return false;
		}
		return true;
	}
}
