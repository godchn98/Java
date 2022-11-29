package studentDBApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses;
	private int tuitionBalance =0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	//Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - freshman \n2 - sophmore\n3 - junior\n4 - senior \n Enter student class level: ");
		this.gradeYear = in.nextInt();
		setStudentID();
		System.out.println(firstName+ " " + lastName + " " + gradeYear + " " + studentID);
		

	}
	
	//Generate an ID
	private void setStudentID() {
		//grade level + id
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	//Enroll in courses
	public void enroll() {
		//Get inside a loop until user hits 0
		do {	
			System.out.println("Enter course to entroll (Q to quit)");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
				}
		 else {break;}
		} while (1 !=0);
		System.out.println("ENROLLED IN: " + courses);
		System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	//view balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}

	
	//pay tuition
	public void payTuition() {
		viewBalance();
		System.out.println("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	//show status
	public String showInfo() {
		return "- "+"Name: " + firstName + " " +lastName + "\n" +
				"- "+"Courses Enrolled: " + courses + "\n" +
				"- "+"Balance: $" + tuitionBalance;
	}
}
