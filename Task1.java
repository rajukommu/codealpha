package codealpha;

import java.util.Scanner;

//STUDENT GRADE TRACKER
public class Task1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		        //  number of students
		        System.out.print("Enter the number of students: ");
		        int numst = sc.nextInt();

		        //  store grades
		        int[] grades = new int[numst];

		        // Input grades from the user
		        for (int i = 0; i < numst; i++) {
		            System.out.print("Enter grade for student  " + (i + 1) + "in numbers : ");
		            grades[i] = sc.nextInt();
		        }

		        //  average, highest, and lowest grades
		        int sum = 0;
		        int highest = grades[0];
		        int lowest = grades[0];

		        for (int grade : grades) {
		            sum += grade;
		            if (grade > highest) {
		                highest = grade;
		            }
		            if (grade < lowest) {
		                lowest = grade;
		            }
		        }

		        double average = (double) sum / numst;

		        // Display results
		        System.out.println("Average Grade: " + average);
		        System.out.println("Highest Grade: " + highest);
		        System.out.println("Lowest Grade: " + lowest);

		  
		    }
		


	}

