package com.jdbc.mysql.test;

import java.util.Scanner;

import com.jdbc.mysql.service.Student;

public class Test {
	
	public static void main(String[] args) {
		
		Student st = new Student();
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		
		do {
			
			//-----------------Menu-----------------------		
			System.out.println("Student Management System");
			System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            
            //----read user choice-------------
            choice = sc.nextInt();
            
            switch(choice) {
             
            	case 1:
            		System.out.println("Enter Student id");
            		int sid = sc.nextInt();
            				
            		System.out.println("Enter Student name");
            		String name = sc.next();
            		
            		System.out.println("Enter Updated mobile number");
            		long mobileNumber = sc.nextLong();
            		
            		// call insertStudent method from Student.java
            		
            		st.insertStudent(sid, name, mobileNumber);
            		break;
            	
            	
            	 case 2:
                     System.out.println("Enter Student id:");
                     int updateId = sc.nextInt();

                     System.out.println("Enter New Mobile number:");
                     long newMobile = sc.nextLong();

                     
                    //call updateStudent() method from Student.java
                     
                     st.updateStudent(updateId, newMobile);
                     break;
                     
                 case 3:
                     System.out.println("Enter Student id to delete:");
                     int deleteId = sc.nextInt();

                     // call deleteStudent() method
                     
                     st.deleteStudent(deleteId);
                     break;

                 case 4:
                	 
                	 //Display all students
                	 
                     st.displayAll();
                     break;

                 case 5:
                     System.out.println("Exiting Program...");
                     break;

                 default:
                     System.out.println("Invalid Choice. Try Again.");
            
            
            }
            
            
		}while(choice!=5);
		
		
	}

}
