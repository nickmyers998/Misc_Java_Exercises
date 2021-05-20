import java.util.ArrayList;
import java.util.Scanner;

// This program works in conjunction with EmployeeAbstract.java to demonstrate abstract classes and inheritance in Java with a user application for University adminitrative duties

public class EmployeeDriver {

	ArrayList<EmployeeAbstract> faculty = new ArrayList<EmployeeAbstract>();		//ArrayList of Employee object type
	int fulltimeSalary = 0;

	public static void main(String[] args) {

		EmployeeDriver obj = new EmployeeDriver();		//creates instance of Driver class
		
		while (true) {		//loop to continuously get user input for functions
			getFaculty();
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch (option) {		//creates instances of different employees and places objects into faculty ArrayList

			case 1:

				FulltimeEmployee ftest = new FulltimeEmployee();
				obj.faculty.add(ftest);
				break;

			case 2:

				FulltimeEmployee adtest = new FulltimeEmployee();
				obj.faculty.add(adtest);
				break;
				
			case 3:
				
				AdjunctEmployee ajtest = new AdjunctEmployee();
				obj.faculty.add(ajtest);
				break;
				
			case 4:
				
				TAEmployee tatest = new TAEmployee();
				obj.faculty.add(tatest);
				break;
				
			case 5:
				
				InstructorEmployee itest = new InstructorEmployee();
				obj.faculty.add(itest);
				break;
				
			case 6:
				
				obj.printPayroll(obj.faculty);
				continue;
				
			case 7:
				
				return;
			}
			
			EmployeeAbstract emp = obj.faculty.get(obj.faculty.size()-1);		//creates Employee reference to last object in ArrayList
			emp.getFullName();
			emp.generateBirthdate();
			emp.thismonth = 6;
			emp.generateBonus();
			emp.calcSalary();
		}
	}

	public static void getFaculty() {		//prints out options to user
		System.out.println("Use number pad to select option:");
		System.out.println("1: Add full time professor");
		System.out.println("2: Add administrator");
		System.out.println("3: Add adjunct professor");
		System.out.println("4: Add graduate TA");
		System.out.println("5: Add instructor");
		System.out.println("6: Print payroll");
		System.out.println("7: Quit");
	}

	public void printPayroll(ArrayList<EmployeeAbstract> faculty) {		//prints payroll for all entered employees

		for (EmployeeAbstract i: faculty) {		//loops through Employee objects in faculty ArrayList
			System.out.println("\nName: " + i.fullName[0] + " " + i.fullName[1]);
			System.out.println("Position: " + i.positionType);
			System.out.println("Birthday: " + i.birthdate[1] + "/" + i.birthdate[0] + "/" + i.birthdate[2]);
			System.out.println("Monthly Salary: " + i.getSalary() + "\n");
		}
	}
}
