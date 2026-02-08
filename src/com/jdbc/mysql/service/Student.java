package com.jdbc.mysql.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
	
	
	
	public void insertStudent(int sid,String sname,long mobile_number) {
		
		//Validate whether student id is positive or not 
		
		if(sid <= 0) {
		    System.out.println("Student ID must be positive");
		    return;
		}
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms",
					"root","lahari@123L");
			PreparedStatement ps = con.prepareStatement("insert into student(sid,sname,mobile_number)values(?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setLong(3, mobile_number);
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Student Inserted Successfully");
			}else {
				System.out.println("Insertion Failed");
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int sid,long mobile_number) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms",
					"root","lahari@123L");
			PreparedStatement ps = con.prepareStatement("update student set mobile_number = ? where sid = ?");
			ps.setLong(1, mobile_number);
			ps.setInt(2, sid);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Student Updated Successfully");
			}else {
				System.out.println("Student Updation Failed");
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	
	
	public void deleteStudent(int sid) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms",
				"root","lahari@123L");
		
		PreparedStatement ps = con.prepareStatement("delete from student where sid = ?");
		ps.setInt(1, sid);
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Student Deleted Successfully");
		}else {
			System.out.println("Student Deletion Failed");
		}
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void displayAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","lahari@123L");
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Student id: "+rs.getInt(1));
				System.out.println("Student Name: "+rs.getString(2));
				System.out.println("Student Mobile Number: "+rs.getLong(3));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
