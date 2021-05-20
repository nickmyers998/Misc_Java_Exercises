import java.util.Scanner;
import java.util.Random;


// This file contains the abstract class Employee, its methods, and its child class declarations


abstract class EmployeeAbstract {		//abstract superclass for Employee objects

	private int salary = 0;
	public String[] fullName = new String[2];
	protected int[] birthdate = new int[3];		//[day, month, year]
	public int thismonth;
	public String positionType;
	
	public void getFullName() {			//gets employee name by user input
		System.out.print("What is the professor's first name?: ");
		Scanner input = new Scanner(System.in);
		String firstName = input.nextLine();
		System.out.print("What is the professor's last name?: ");
		String lastName = input.nextLine();
		fullName[0] = firstName;
		fullName[1] = lastName;
	}
	
	public boolean checkValidDate(int day, int month, int year) {		//checks if randomly generated date is valid, reused code from old assignment
		if (day == 31) {
			if (month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12) {
				return false;
			}
		}
		if (month == 2) {
			if (day > 29) {
				return false;
			}
			if (day == 29) {
				if (year % 4 != 0) {
					return false;
				}
				else {
					if (year % 100 == 0 && year % 400 != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void generateBirthdate() {		//randomly generates birth date for employee
		while (true) {
			Random gen = new Random();
			int age = gen.nextInt(35) + 26;
			int year = 2020 - age;
			int month = gen.nextInt(12) + 1;
			int day = gen.nextInt(31) + 1;
			boolean dateTest = checkValidDate(day, month, year);
			if (dateTest == true) {
				birthdate[0] = day;
				birthdate[1] = month;
				birthdate[2] = year;
				break;
			}
			else {
				continue;
			}
		}
	}
	
	public void generateBonus(){		//adds birth month bonus to employee salary
		if (birthdate[1] == thismonth) {
			setSalary(getSalary() + 100);
		}
	}
	
	public abstract void calcSalary();		//abstract method to calculate salary


	public int getSalary() {		//salary getter
		return salary;
	}


	public void setSalary(int salary) {		//salary setter
		this.salary = salary;
	}
}

class FulltimeEmployee extends EmployeeAbtract {
	
	public FulltimeEmployee() {
		positionType = "Full-time Professor or Administrator";
	}
	
	@Override
	public void calcSalary() {
		Random gen = new Random();
		setSalary(gen.nextInt(2000) + 8001);
	}
}

class AdjunctEmployee extends EmployeeAbstract {
	
	public AdjunctEmployee() {
		positionType = "Adjunct Professor";
	}
	
	@Override
	public void calcSalary() {
		Random gen = new Random();
		int basesalary = gen.nextInt(3000) + 5001;
		int coursenum = gen.nextInt(6) + 1;
		setSalary(basesalary + (coursenum*1000));
	}
}

class InstructorEmployee extends EmployeeAbstract {
	
	public InstructorEmployee() {
		positionType = "Instructor";
	}
	
	@Override
	public void calcSalary() {
		Random gen = new Random();
		int coursenum = gen.nextInt(6) + 1;
		setSalary((coursenum*1000));
	}
}

class TAEmployee extends EmployeeAbstract {
	
	public TAEmployee() {
		positionType = "Graduate TA";
	}
	
	@Override
	public void calcSalary() {
		int hourly = 17;
		int otpay = 20;
		int overtime = 0;
		Random gen = new Random();
		int workhours = gen.nextInt(70) + 31;
		if (workhours > 80) {
			overtime = workhours - 80;
			workhours -= overtime;
		}
		setSalary((hourly*workhours) + (otpay*overtime));
	}
}
